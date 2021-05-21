package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.MinAppUser;
import com.aoyang.wx.work.domain.UserDetail;
import com.aoyang.wx.work.domain.UserInfo;
import com.aoyang.wx.work.model.FlagEnum;
import com.aoyang.wx.work.model.WxWorkRe;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.UserService;
import com.aoyang.wx.work.service.remote.WxWorkService;
import com.ruoyi.common.core.exception.BaseException;
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
public class UserServiceImpl implements UserService {

    @Resource
    private AccessService wxAccessService;

    @Resource
    private WxWorkService wxWorkService;

    @Override
    public String getUser(String agentId, String code) {
        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);

        //获取用户id
        final UserInfo userInfo = wxWorkService.getUserId(accessToken, code);

        //这里只处理内部员工
        if (userInfo.getErrcode().equals(0) && userInfo.getUserId() != null) {
            return userInfo.getUserId();
        }
        log.error("未正确获取用户信息，{}", userInfo.getErrmsg());
        throw new BaseException("未正确获取用户信息," + userInfo.getErrmsg());
    }

    @Override
    public String getMiniAppUser(String agentId, String code) {
        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);
        final MinAppUser minAppUser = wxWorkService.getMinAppUserId(accessToken, code);
        if (minAppUser.getErrcode().equals(0)) {
            return minAppUser.getUserid();
        }
        log.error("未正确获取用户信息，{}", minAppUser.getErrmsg());
        throw new BaseException("未正确获取用户信息," + minAppUser.getErrmsg());
    }

    @Override
    public WxWorkRe getuserDetail(String agentId, String userId) {
        UserDetail userDetail = null;
        String accessToken = wxAccessService.getAccessToken(agentId);
        userDetail = wxWorkService.getUserDetail(accessToken, userId);
        if (Constant.TIME_OUT_CODE.equals(userDetail.getErrcode().toString())) {
            String s = wxAccessService.refreshAccessToken(agentId);
            userDetail = wxWorkService.getUserDetail(s, userId);
        }
        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(userDetail.getErrcode().toString())) {
            msgRe.flag = FlagEnum.SUCCESS.getCode();
        } else {
            msgRe.flag = FlagEnum.FAIL.getCode();
        }
        msgRe.code = userDetail.getErrcode();
        msgRe.info = userDetail.getErrmsg();
        msgRe.data = userDetail;
        return msgRe;
    }


}
