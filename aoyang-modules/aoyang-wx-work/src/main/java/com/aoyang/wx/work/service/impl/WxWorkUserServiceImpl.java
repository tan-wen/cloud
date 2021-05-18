package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.domain.MinAppUser;
import com.aoyang.wx.work.domain.UserInfo;
import com.aoyang.wx.work.service.WxAccessService;
import com.aoyang.wx.work.service.WxWorkRemoteService;
import com.aoyang.wx.work.service.WxWorkUserService;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName WxWorkUserServiceImpl
 * @description: 获取用户信息
 * @author: went
 * @Date 2021/5/17 11:16 上午
 **/
@Service
@Slf4j
public class WxWorkUserServiceImpl implements WxWorkUserService {

    @Resource
    private WxAccessService wxAccessService;

    @Resource
    private WxWorkRemoteService wxWorkRemoteService;

    @Override
    public LoginUser getUser(String agentId, String code) {
        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);

        //获取用户id
        final UserInfo userInfo = wxWorkRemoteService.getUserId(accessToken, code);

        //这里只处理内部员工
        if (userInfo.getErrcode().equals(0) && userInfo.getUserId() != null) {
            LoginUser loginUser = new LoginUser();
            SysUser sysUser = new SysUser();
            //注意，这里是工号对应登录的系统用户名
            sysUser.setUserName(userInfo.getUserId());
            loginUser.setSysUser(sysUser);
            return loginUser;
        }
        log.error("未正确获取用户信息，{}", userInfo.getErrmsg());
        throw new BaseException("未正确获取用户信息," + userInfo.getErrmsg());
    }

    @Override
    public LoginUser getMiniAppUser(String agentId, String code) {
        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);
        final MinAppUser minAppUser = wxWorkRemoteService.getMinAppUserId(accessToken, code,
                "authorization_code");
        if (minAppUser.getErrcode().equals(0)) {
            LoginUser loginUser = new LoginUser();
            SysUser sysUser = new SysUser();
            //注意，这里是工号对应登录的系统用户名
            sysUser.setUserName(minAppUser.getUserid());
            loginUser.setSysUser(sysUser);
            return loginUser;
        }
        log.error("未正确获取用户信息，{}", minAppUser.getErrmsg());
        throw new BaseException("未正确获取用户信息," + minAppUser.getErrmsg());
    }
}
