package com.aoyang.wx.mp.service;

import com.aoyang.wx.mp.dto.WxAccessToken;
import com.aoyang.wx.mp.dto.WxOAuth2Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName WxMpRemoteService
 * @description: 微信公众号接口
 * @author: went
 * @Date 2021/5/19 2:10 下午
 **/
@FeignClient(value = "wxMpRemoteService", url = "https://api.weixin.qq.com")
public interface WxMpRemoteService {

    /**
     * 获取accessToken
     * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     */
    @GetMapping("/cgi-bin/token?grant_type=client_credential")
    WxAccessToken getToken(@RequestParam(name = "appid") String appId, @RequestParam(name = "secret") String secret);

    /**
     * 获取网页授权accessToken
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     */
    @GetMapping("/sns/oauth2/access_token?grant_type=authorization_code")
    WxOAuth2Token getOauth2Token(@RequestParam(name = "appid")String appId,
                                 @RequestParam(name = "secret")String secret,
                                 @RequestParam(name = "code")String code);
}
