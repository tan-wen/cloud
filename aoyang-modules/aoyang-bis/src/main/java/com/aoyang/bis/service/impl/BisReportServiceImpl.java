package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.wxapi.WxSystemApi;
import com.aoyang.bis.domain.BisReport;
import com.aoyang.bis.mapper.BisReportMapper;
import com.aoyang.bis.service.BisReportService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;


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
    private WxSystemApi wxSystemApi;


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

        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());
        bisReport.setName(usreInfo.getNickName());
        bisReport.setCommenterId( SecurityUtils.getUsername());
        bisReport.setCreateTime(LocalDateTime.now());
        this.save(bisReport);
        return Result.ok("保存成功");
    }
}
