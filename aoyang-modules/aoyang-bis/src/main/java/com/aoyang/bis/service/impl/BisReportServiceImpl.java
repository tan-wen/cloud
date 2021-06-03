package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.wxapi.WxSystemApi;
import com.aoyang.bis.common.wxapi.WxWorkApi;
import com.aoyang.bis.domain.BisList;
import com.aoyang.bis.domain.BisReport;
import com.aoyang.bis.mapper.BisListMapper;
import com.aoyang.bis.mapper.BisReportMapper;
import com.aoyang.bis.service.BisReportService;
import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.aoyang.wx.work.model.info.applets.ContentItem;
import com.aoyang.wx.work.model.info.applets.MiniprogramNotice;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;


/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@Service
public class BisReportServiceImpl extends ServiceImpl<BisReportMapper, BisReport> implements BisReportService {

    @Autowired
    private BisReportMapper bisReportMapper;
    @Autowired
    private BisListMapper bisListMapper;
    @Autowired
    private WxSystemApi wxSystemApi;
    @Autowired
    private WxWorkApi wxWorkApi;
    @Value("${agentId}")
    private String agentId;
    @Value("${appId}")
    private String appId;
    @Value("${tagId}")
    private String tagId;


    @Override
    public Result<?> findByPid(String id) {
        QueryWrapper<BisReport> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id);
        wrapper.orderByDesc("create_time");
        List<BisReport> bisReports = bisReportMapper.selectList(wrapper);
        return Result.ok(bisReports);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> addinfo(BisReport bisReport) {

        BisList bisList = bisListMapper.selectById(bisReport.getPid());

        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());
        bisReport.setName(usreInfo.getNickName());
        bisReport.setCommenterId( SecurityUtils.getUsername());
        bisReport.setCreateTime(LocalDateTime.now());
        this.save(bisReport);

        HashMap<String, String> map = new HashMap<>();
        map.put("评论人：",usreInfo.getNickName());
        send("您的BIS收到了一条评论",bisList.getTitle(),bisList.getSubmitterId(),map,"/pages/list/detail?id=" + bisReport.getPid());

        return Result.ok("保存成功");
    }

    private Boolean send(String title, String firstMsg, String touser, Map<String,String> info, String page) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = format.format(new Date());

        AppletsInfo appletsInfo = new AppletsInfo();
        MiniprogramNotice miniprogramNotice = new MiniprogramNotice();
        ArrayList<ContentItem> contentItems = new ArrayList<>();
        ContentItem contentItem = new ContentItem();
        contentItem.setKey("标题");
        contentItem.setValue(firstMsg);
        contentItems.add(contentItem);
        info.forEach((k,v)->{
            ContentItem cont = new ContentItem();
            cont.setKey(k);
            cont.setValue(v);
            contentItems.add(cont);
        });
        miniprogramNotice.setAppId(appId);
        miniprogramNotice.setTitle(title);
        miniprogramNotice.setDescription(date);
        miniprogramNotice.setEmphasisFirstItem(true);
        miniprogramNotice.setContentItem(contentItems);
        miniprogramNotice.setPage(page);
        appletsInfo.setMiniprogramNotice(miniprogramNotice);
        appletsInfo.setMsgtype("miniprogram_notice");
        appletsInfo.setTouser(touser);
        return wxWorkApi.sendMessage(agentId,appletsInfo);
    }
}
