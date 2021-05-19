package com.aoyang.wx.mp.dto;

import lombok.Data;

/**
 * @ClassName WxOAuth2AccessToken
 * @description: 网页授权Access_token
 *
 * {
 *   "access_token":"ACCESS_TOKEN",
 *   "expires_in":7200,
 *   "refresh_token":"REFRESH_TOKEN",
 *   "openid":"OPENID",
 *   "scope":"SCOPE"
 * }
 *
 * @author: went
 * @Date 2021/5/19 3:05 下午
 **/
@Data
public class WxOAuth2Token extends WxAccessToken {

    private String refresh_token;

    private String openid;

    private String scope;
}
