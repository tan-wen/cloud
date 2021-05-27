package com.aoyang.wx.work.service.remote;

import com.aoyang.wx.work.domain.AccessToken;
import com.aoyang.wx.work.domain.MinAppUserId;
import com.aoyang.wx.work.domain.WxUser;
import com.aoyang.wx.work.domain.WxUserId;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @ClassName WxWorkRemoteService
 * @description: 使用openfeign封装企业微信接口
 * @author: went
 * @Date 2021/5/17 3:54 下午
 **/
@FeignClient(value = "wxWorkRemoteService", url = "https://qyapi.weixin.qq.com/cgi-bin")
public interface WxWorkService {

    @GetMapping("/gettoken")
    AccessToken getAccessToken(@RequestParam(name = "corpid") String appId,
                               @RequestParam(name = "corpsecret") String secret);

    @GetMapping("/user/getuserinfo")
    WxUserId getUserId(@RequestParam(name = "access_token") String accessToken,
                       @RequestParam(name = "code") String code);

    @GetMapping("/miniprogram/jscode2session?grant_type=authorization_code")
    MinAppUserId getMinAppUserId(@RequestParam(name = "access_token")String accessToken,
                                 @RequestParam(name = "js_code") String code);

    @GetMapping("/user/get")
    WxUser getUser(@RequestParam(name = "access_token")String accessToken,
                   @RequestParam(name="userid")String userId);


}
