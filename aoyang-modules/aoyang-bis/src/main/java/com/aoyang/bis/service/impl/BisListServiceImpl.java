package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.utils.LocalDateTimeUtil;
import com.aoyang.bis.common.wxapi.WxSystemApi;
import com.aoyang.bis.common.wxapi.WxWorkApi;
import com.aoyang.bis.domain.*;
import com.aoyang.bis.dto.BisListAddDto;
import com.aoyang.bis.dto.CreatePersonList;
import com.aoyang.bis.mapper.BisListMapper;
import com.aoyang.bis.service.BisDetailService;
import com.aoyang.bis.service.BisListFileService;
import com.aoyang.bis.service.BisListService;
import com.aoyang.bis.service.UserOperationService;
import com.aoyang.wx.work.model.TagMember;
import com.aoyang.wx.work.model.WxUserInfo;
import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.aoyang.wx.work.model.info.applets.ContentItem;
import com.aoyang.wx.work.model.info.applets.MiniprogramNotice;
import com.aoyang.wx.work.utils.targetStringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@Service
public class BisListServiceImpl extends ServiceImpl<BisListMapper, BisList> implements BisListService {

    @Autowired
    private BisListMapper bisListMapper;
    @Autowired
    private BisDetailService bisDetailService;
    @Autowired
    private UserOperationService userOperationService;
    @Autowired
    private BisListFileService bisListFileService;
    @Autowired
    private WxWorkApi wxWorkApi;
    @Autowired
    private WxSystemApi wxSystemApi;
    @Value("${agentId}")
    private String agentId;
    @Value("${appId}")
    private String appId;
    @Value("${tagId}")
    private String tagId;



    @Override
    public Result<?> findAll(String state, String submitterId, LocalDateTime createTime, String classification, String secondaryClassification) throws ParseException {
        return Result.ok(this.getAllinfo(state, submitterId, createTime, classification, secondaryClassification));
    }

    @Override
    public Result<?> findCreateList(String name) {
        List<CreatePersonList> createList = bisListMapper.findCreateList(name);
        return Result.ok(createList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> updateInfo(String id) {
        BisList bisList = this.getById(id);
        bisList.setView(bisList.getView() + 1);
        this.updateById(bisList);
        return Result.ok("增加成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> supportOrNot(String id, String type) {
        BisList bisList = this.getById(id);


        if (SupportEnum.SUPPORT.getCode().equals(type)) {
            QueryWrapper<UserOperation> userOperationQueryWrapper = new QueryWrapper<>();
            userOperationQueryWrapper.eq("pid",id);
            userOperationQueryWrapper.eq("user_id", SecurityUtils.getUsername());
            userOperationQueryWrapper.eq("type", "support");
            UserOperation one = userOperationService.getOne(userOperationQueryWrapper);
            if (null != one) {
                return Result.error(200, "已经点赞过");
            }
            bisList.setSupport(bisList.getSupport() + 1);
            userOperationService.addInfo(id,"support",   SecurityUtils.getUsername());
        }
        if (SupportEnum.UNSUPPORT.getCode().equals(type)) {
            QueryWrapper<UserOperation> userOperationQueryWrapper = new QueryWrapper<>();
            userOperationQueryWrapper.eq("pid",id);
            userOperationQueryWrapper.eq("user_id",   SecurityUtils.getUsername());
            userOperationQueryWrapper.eq("type", "unsupported");
            UserOperation one = userOperationService.getOne(userOperationQueryWrapper);
            if (null != one) {
                return Result.error(200, "已经踩过");
            }
            bisList.setUnsupported(bisList.getUnsupported() + 1);
            userOperationService.addInfo(id,"unsupported",   SecurityUtils.getUsername());
        }
        this.updateById(bisList);
        return Result.ok(bisList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> addBis(BisListAddDto bisListAddDto) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String detailid = UUID.randomUUID().toString().replace("-", "");
        BisList bisList = this.buildBisList(id, bisListAddDto);
        BisDetail bisDetail = this.buildBisDetail(id, detailid,bisListAddDto);
        List<BisListFile> bisListFiles = buildFileList(bisListAddDto.getPictureids(), detailid);
        bisListFileService.saveBatch(bisListFiles);
        this.save(bisList);
        bisDetailService.save(bisDetail);

        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());

        TagMember tagMember = wxWorkApi.findTagMember(agentId, tagId);
        List<WxUserInfo> userList = tagMember.getUserlist();

        //此处的userId为微信传回来的工号。
        List<String> useridlist = userList.stream().map(e -> e.getUserId()).collect(Collectors.toList());
        String s = targetStringUtil.buildTarget(useridlist);

        //推送消息
        send("【" + bisList.getTitle() + "】", s, "提出人：", usreInfo.getNickName(), id);
        return Result.ok("添加成功");

    }

    @Override
    public Result<?> findMyList(String state, LocalDateTime createTime, String classification, String type, String secondaryClassification) throws ParseException {
        String startTime ="";
        String endTime="";
        if(createTime!=null){
            LocalDateTime start = LocalDateTimeUtil.getDateInfo(createTime, "start");
            LocalDateTime end = LocalDateTimeUtil.getDateInfo(createTime, "end");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            startTime = dateTimeFormatter.format(start);
            endTime = dateTimeFormatter.format(end);
        }

        if(ListTypeEnum.PROPOSE.getCode().equals(type)){
            return Result.ok(this.getAllinfo(state, SecurityUtils.getUsername(), createTime, classification, secondaryClassification));
        }
        else if(ListTypeEnum.INCHARGE.getCode().equals(type)) {
            return Result.ok(bisListMapper.findMyCharge(state, SecurityUtils.getUsername(), startTime ,endTime, classification, secondaryClassification));
        }
        else {
            return Result.ok(bisListMapper.findAllInfo(state, SecurityUtils.getUsername(),  startTime ,endTime, classification, secondaryClassification));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> claimBis(String id) {
        BisList bisList = this.getById(id);
        if (!StatusEnum.UNPROCESSED.getCode().equals(bisList.getState())) {
            return Result.error(200, "认领失败，状态已变更，或已被他人操作");
        }
        QueryWrapper<BisDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        BisDetail bisDetail = bisDetailService.getOne(wrapper);
        bisList.setState(StatusEnum.CLAIMED.getCode());
        bisDetail.setAssignedTime(LocalDateTime.now());//指派和认领时间一致
        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());
        bisDetail.setChargePerson(usreInfo.getNickName());
        bisDetail.setChargePersonId(SecurityUtils.getUsername());
        this.updateById(bisList);
        bisDetailService.updateById(bisDetail);
        return Result.ok("认领成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> startBis(String id) {
        BisList bisList = this.getById(id);
        if(!(StatusEnum.CLAIMED.getCode().equals(bisList.getState())||StatusEnum.ACCEPTED.getCode().equals(bisList.getState()))){
            return Result.error(200,"开始失败，状态已变更");
        }
        QueryWrapper<BisDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id);
        BisDetail bisDetail = bisDetailService.getOne(wrapper);
        bisList.setState(StatusEnum.ONGOING.getCode());
        bisDetail.setStartTime(LocalDateTime.now());
        this.updateById(bisList);
        bisDetailService.updateById(bisDetail);
        return Result.ok("开始成功");
    }

    @Override
    public Result<?> finishBis(String id) {
        BisList bisList = this.getById(id);
        if(!(StatusEnum.ONGOING.getCode().equals(bisList.getState()))){
            return Result.error(200,"结束失败，状态已变更");
        }
        QueryWrapper<BisDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id);
        BisDetail bisDetail = bisDetailService.getOne(wrapper);
        bisList.setState(StatusEnum.FINISHED.getCode());
        bisDetail.setEndTime(LocalDateTime.now());
        this.updateById(bisList);
        bisDetailService.updateById(bisDetail);

        send("您有一条BIS已被完成", bisList.getSubmitterId(), "提出人", bisList.getSubmitter(), id);
        return Result.ok("完成成功");
    }

    @Override
    public Result<?> cancelBis(String id) {
        BisList bisList = this.getById(id);
        if(!(StatusEnum.UNPROCESSED.getCode().equals(bisList.getState()))){
            return Result.error(200,"取消失败，状态已变更，或已被指派或认领");
        }
        bisList.setState(StatusEnum.CANCELLED.getCode());
        this.updateById(bisList);
        return Result.ok("取消成功");

    }

    @Override
    public Result<?> backBis(String id) {
        BisList bisList = this.getById(id);
        if(!(StatusEnum.ASSIGNED.getCode().equals(bisList.getState()))){
            return Result.error(200,"驳回失败，状态已变更");
        }
        bisList.setState(StatusEnum.CANCELLED.getCode());
        this.updateById(bisList);
        return Result.ok("驳回成功");

    }

    @Override
    public Result<?> assginBis(String id,CreatePersonList user) {
        BisList bisList = this.getById(id);
        if (!(StatusEnum.UNPROCESSED.getCode().equals(bisList.getState()))) {
            return Result.error(200, "指派失败，状态已变更");
        }
        QueryWrapper<BisDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        BisDetail bisDetail = bisDetailService.getOne(wrapper);
        bisList.setState(StatusEnum.ASSIGNED.getCode());
        bisDetail.setChargePersonId(user.getUserId());
        bisDetail.setChargePerson(user.getName());

        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());

        bisDetail.setDesignator(usreInfo.getNickName());
        bisDetail.setDesignatorId(SecurityUtils.getUsername());
        bisDetail.setAssignedTime(LocalDateTime.now());

        this.updateById(bisList);
        bisDetailService.updateById(bisDetail);
        return Result.ok("指派成功");

    }

    @Override
    public Result<?> acceptBis(String id) {
        BisList bisList = this.getById(id);
        if(!(StatusEnum.ASSIGNED.getCode().equals(bisList.getState()))){
            return Result.error(200,"接受失败，状态已变更");
        }
        bisList.setState(StatusEnum.ACCEPTED.getCode());
        this.updateById(bisList);
        return Result.ok("接受成功");
    }

    private  List<BisList> getAllinfo(String state, String submitterId, LocalDateTime createTime, String classification, String secondaryClassification) throws ParseException {
        QueryWrapper<BisList> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(state)) {
            wrapper.eq("state", state);
        }
        if (StringUtils.isNotEmpty(submitterId)) {
            wrapper.eq("submitter_id", submitterId);
        }
        if (createTime != null) {
            wrapper.between("create_time", LocalDateTimeUtil.getDateInfo(createTime, "start"), LocalDateTimeUtil.getDateInfo(createTime, "end"));
        }
        if (StringUtils.isNotEmpty(classification)) {
            wrapper.eq("classification", classification);
        }
        if (StringUtils.isNotEmpty(secondaryClassification)) {
            wrapper.eq("secondary_classification", secondaryClassification);
        }

        wrapper.orderByDesc("create_time");

        return bisListMapper.selectList(wrapper);
    }

    private BisList buildBisList(String id,BisListAddDto bisListAddDto) {
        SysUser usreInfo = wxSystemApi.findUsreInfo(SecurityUtils.getUsername());
       return BisList.builder()
               .id(id)
               .state(StatusEnum.UNPROCESSED.getCode())
               .title(bisListAddDto.getTitle())
               .submitter(usreInfo.getNickName())
               .submitterId(  SecurityUtils.getUsername())
               .createTime(LocalDateTime.now())
               .view(1)
               .support(0)
               .unsupported(0)
               .classification(bisListAddDto.getClassification())
               .secondaryClassification(bisListAddDto.getSecondaryClassification())
               .build();

    }

    private BisDetail buildBisDetail(String id,String detailid,BisListAddDto bisListAddDto) {
        return BisDetail.builder()
                .id(detailid)
                .pid(id)
                .title(bisListAddDto.getTitle())
                .describeInfo(bisListAddDto.getDescribeInfo())
                .importance(bisListAddDto.getImportance())
                .urgency(bisListAddDto.getUrgency())
                .intention(bisListAddDto.getIntention())
                .intentionId(bisListAddDto.getIntentionId())
                .remarks(bisListAddDto.getRemarks())
                .build();
    }

    private List<BisListFile> buildFileList(String url,String id){
        ArrayList<BisListFile> bisListFiles = new ArrayList<>();
        String[] split = url.split(",");
        for (String s : split) {
            BisListFile bisListFile = new BisListFile();
            bisListFile.setId(UUID.randomUUID().toString().replace("-",""));
            bisListFile.setDetailId(id);
            bisListFile.setUrl(s);
            bisListFiles.add(bisListFile);
        }
        return bisListFiles;
    }

    private Boolean send(String title, String touser, String key, String value, String id) {
        AppletsInfo appletsInfo = new AppletsInfo();
        MiniprogramNotice miniprogramNotice = new MiniprogramNotice();
        ContentItem contentItem = new ContentItem();
        contentItem.setKey(key);
        contentItem.setValue(value);
        ArrayList<ContentItem> contentItems = new ArrayList<>();
        miniprogramNotice.setAppId(appId);
        miniprogramNotice.setTitle(title);
        miniprogramNotice.setContentItem(contentItems);
        miniprogramNotice.setPage("/pages/list/detail?id=" + id);
        appletsInfo.setMiniprogramNotice(miniprogramNotice);
        appletsInfo.setMsgtype("miniprogram_notice");
        appletsInfo.setTouser(touser);
        return wxWorkApi.sendMessage(agentId,appletsInfo);
    }

}



