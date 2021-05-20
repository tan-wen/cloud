package com.aoyang.wx.mp.service.remote;

import com.aoyang.wx.mp.dto.WxMsgR;
import com.aoyang.wx.mp.dto.WxTemplateMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName WxMpMsgService
 * @description: 微信公众号消息接口
 * @author: went
 * @Date 2021/5/20 10:37 上午
 **/
@FeignClient(value = "wxMpMsgService", url = "https://api.weixin.qq.com/cgi-bin")
public interface WxMpMsgService {

    /**
     * 发送模板消息
     * WxMpMsgService
     * POST https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
     */
    @PostMapping("message/template/send")
    WxMsgR sendMsg(@RequestParam(name = "access_token")String accessToken, @RequestBody WxTemplateMsg templateMsg);
}
