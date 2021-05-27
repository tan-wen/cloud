package com.aoyang.bis.common.wxapi;

import com.aoyang.wx.work.model.TagMember;
import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = ServiceNameConstants.AOYANG_WX_WORK)
public interface WxWorkApi {

    @PostMapping("/msg/app/{agentId}")
    Boolean sendMessage(@PathVariable(value = "agentId") String agentId, @RequestBody AppletsInfo data);

    @GetMapping("/maillist/{agentId}/{tagId}")
    TagMember findTagMember(@PathVariable(value = "agentId") String agentId, @PathVariable(value = "tagId") String tagId);

}
