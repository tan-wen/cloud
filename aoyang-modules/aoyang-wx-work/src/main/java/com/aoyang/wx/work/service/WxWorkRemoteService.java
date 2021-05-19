package com.aoyang.wx.work.service;

import com.aoyang.wx.work.domain.AccessToken;
import com.aoyang.wx.work.domain.MinAppUser;
import com.aoyang.wx.work.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @ClassName WxWorkRemoteService
 * @description: 使用openfeign封装企业微信接口
 * @author: went
 * @Date 2021/5/17 3:54 下午
 **/
@FeignClient(value = "wxWorkRemoteService", url = "https://qyapi.weixin.qq.com/cgi-bin")
public interface WxWorkRemoteService {

    @GetMapping("/gettoken")
    AccessToken getAccessToken(@RequestParam(name = "corpid")String appId,
                               @RequestParam(name = "corpsecret")String secret);

    @GetMapping("/user/getuserinfo")
    UserInfo getUserId(@RequestParam(name = "access_token")String accessToken,
                       @RequestParam(name = "code") String code);

    @GetMapping("/miniprogram/jscode2session?grant_type=authorization_code")
    MinAppUser getMinAppUserId(@RequestParam(name = "access_token")String accessToken,
                               @RequestParam(name = "js_code") String code);
}
