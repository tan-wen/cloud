package com.aoyang.wx.mp.service.remote;

import com.aoyang.wx.mp.dto.WxOAuth2Token;
import com.aoyang.wx.mp.dto.WxUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName WxMpUserService
 * @description:
 * @author: went
 * @Date 2021/5/25 2:41 下午
 **/
@FeignClient(value = "wxMpUserService", url = "https://api.weixin.qq.com/sns")
public interface WxMpUserService {

    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     */
    @GetMapping("/oauth2/access_token?grant_type=authorization_code")
    WxOAuth2Token getOauth2Token(@RequestParam(name = "appid")String appId,
                                 @RequestParam(name = "secret")String secret,
                                 @RequestParam(name = "code")String code);

    /**
     * 获取粉丝信息
     * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
     */
    @GetMapping("/userinfo?&lang=zh_CN")
    WxUser getUser(@RequestParam(name = "access_token") String accessToken,
                   @RequestParam(name = "openid") String openId);
}
