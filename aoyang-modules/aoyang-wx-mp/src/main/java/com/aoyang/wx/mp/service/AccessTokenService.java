package com.aoyang.wx.mp.service;

import com.aoyang.wx.mp.dto.WxOAuth2Token;

/**
 * @ClassName AccessTokenService
 * @description: 公众号接口Access_token获取
 * @author: went
 * @Date 2021/5/19 2:09 下午
 **/
public interface AccessTokenService {

    String getAccessToken(String appId);

    String refreshAccessToken(String appId);
}
