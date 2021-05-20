package com.aoyang.bis.common.wxapi;

import com.aoyang.wx.work.model.WxWorkRe;
import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = ServiceNameConstants.AOYANG_WX_WORK)
public interface WxWorkApi {

    @GetMapping("/user/{agentId}/{userId}")
    WxWorkRe getDetail(String agentId,String userId);

    @GetMapping("/msg/app/{agentId}")
    WxWorkRe sendMessage(String agentId, AppletsInfo data);

}
