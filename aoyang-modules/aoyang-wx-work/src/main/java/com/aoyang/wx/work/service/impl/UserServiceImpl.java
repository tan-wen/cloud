package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.domain.MinAppUserId;
import com.aoyang.wx.work.domain.WxUser;
import com.aoyang.wx.work.domain.WxUserId;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.UserService;
import com.aoyang.wx.work.service.remote.WxWorkService;
import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.system.api.domain.SysUser;
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
    public SysUser getUser(String agentId, String code) {

        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);

        //获取用户id

        final WxUserId wxUserId = wxWorkService.getUserId(accessToken, code);

        //内部员工
        if (wxUserId.getErrCode().equals(0) && wxUserId.getUserId() != null) {

            //获取员工id，获取员工详细信息
            return makeUpSysUser(accessToken, wxUserId.getUserId());
        }
        log.error("未正确获取用户信息，{}", wxUserId.getErrMsg());
        throw new BaseException("未正确获取用户信息," + wxUserId.getErrMsg());
    }

    @Override
    public SysUser getMiniAppUser(String agentId, String code) {
        //获取access_token
        final String accessToken = wxAccessService.getAccessToken(agentId);
        final MinAppUserId minAppUserId = wxWorkService.getMinAppUserId(accessToken, code);
        if (minAppUserId.getErrCode().equals(0)) {
            return makeUpSysUser(accessToken, minAppUserId.getUserId());
        }
        log.error("未正确获取用户信息，{}", minAppUserId.getErrMsg());
        throw new BaseException("未正确获取用户信息," + minAppUserId.getErrMsg());
    }

    /*
     * 根据用户ID获取用户详情信息并组装SysUser
     * @param accessToken
     * @param userId
     * @return
     */
    private SysUser makeUpSysUser(String accessToken, String userId) {
        final WxUser user = wxWorkService.getUser(accessToken, userId);
        SysUser sysUser = new SysUser();
        sysUser.setUserName(user.getUserId());
        sysUser.setNickName(user.getName());
        sysUser.setEmail(user.getEmail());
        sysUser.setAvatar(user.getAvatar());
        sysUser.setPassword(Constants.DEFAULT_PASSWORD);
        sysUser.setSex(switchGender(user.getGender()));
        sysUser.setPhonenumber(user.getMobile());
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
