package com.aoyang.wx.mp.service.impl;

import com.aoyang.wx.mp.config.WxMps;
import com.aoyang.wx.mp.dto.WxOAuth2Token;
import com.aoyang.wx.mp.dto.WxUser;
import com.aoyang.wx.mp.service.UserService;
import com.aoyang.wx.mp.service.remote.WxMpUserService;
import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.system.api.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: went
 * @Date 2021/5/19 3:30 下午
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private WxMps wxMps;

    @Resource
    private WxMpUserService wxMpUserService;

    @Override
    public SysUser getOpenId(String appId, String code) {

        final WxOAuth2Token token = wxMpUserService.getOauth2Token(appId, wxMps.getSecretByAppId(appId), code);

        if (token.getOpenId() != null) {
            return makeUpSysUser(token);
        }
        log.error("微信公众号无法获取粉丝信息.{}", token.getErrMsg());
        throw new BaseException("微信公众号无法获取粉丝信息." + token.getErrMsg());
    }

    private SysUser makeUpSysUser(WxOAuth2Token token) {
        final String accessToken = token.getAccessToken();
        final WxUser user = wxMpUserService.getUser(accessToken, token.getOpenId());
        SysUser sysUser = new SysUser();
        if (user != null) {
            //授权作用域为snsapi_userinfo
            sysUser.setUserName(user.getOpenId());
            sysUser.setAvatar(user.getHeadImgUrl());
            sysUser.setNickName(user.getNickname());
            sysUser.setSex(switchGender(user.getSex()));
        } else {
            //当授权作用域为snsapi_base
            final String openId = token.getOpenId();
            sysUser.setUserName(openId);

            //昵称使用openId
            sysUser.setNickName(openId);

            //性别：未知
            sysUser.setSex("2");
        }
        sysUser.setPassword(Constants.DEFAULT_PASSWORD);
        return sysUser;
    }

    /*
     * 性别表示转化
     * 未定义  0 --> 2
     * 男性    1 --> 0
     * 女性    2 --> 1
     */
    private String switchGender(String gender) {
        switch (gender) {
            case "1":
                return "0";
            case "2":
                return "1";
            default:
                return "2";
        }
    }
}
