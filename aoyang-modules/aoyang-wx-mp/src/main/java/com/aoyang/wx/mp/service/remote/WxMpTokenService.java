package com.aoyang.wx.mp.service.remote;

import com.aoyang.wx.mp.dto.WxAccessToken;
import com.aoyang.wx.mp.dto.WxOAuth2Token;
import com.aoyang.wx.mp.dto.WxUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName WxMpRemoteService
 * @description: 微信公众号接口
 * @author: went
 * @Date 2021/5/19 2:10 下午
 **/
@FeignClient(value = "wxMpTokenService", url = "https://api.weixin.qq.com/cgi-bin")
public interface WxMpTokenService {

    /**
     * 获取accessToken
     * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     */
    @GetMapping("/token?grant_type=client_credential")
    WxAccessToken getToken(@RequestParam(name = "appid") String appId, @RequestParam(name = "secret") String secret);


}
