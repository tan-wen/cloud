package com.aoyang.wx.mp.service.impl;

import com.aoyang.wx.mp.config.WxMps;
import com.aoyang.wx.mp.dto.WxOAuth2Token;
import com.aoyang.wx.mp.service.UserService;
import com.aoyang.wx.mp.service.remote.WxMpTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: went
 * @Date 2021/5/19 3:30 下午
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private WxMps wxMps;

    @Resource
    private WxMpTokenService wxMpTokenService;

    @Override
    public String getOpenId(String appId, String code) {

        final WxOAuth2Token token = wxMpTokenService.getOauth2Token(appId, wxMps.getSecretByAppId(appId), code);

        if (token.getOpenid() != null) {
            return token.getOpenid();
        }
        return null;
    }
}
