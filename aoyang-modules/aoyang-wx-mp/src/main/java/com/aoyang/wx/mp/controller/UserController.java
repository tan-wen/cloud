package com.aoyang.wx.mp.controller;

import com.aoyang.wx.mp.config.WxMps;
import com.aoyang.wx.mp.service.UserService;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @description: 微信公众号用户
 * @author: went
 * @Date 2021/5/19 1:16 下午
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/wx/mp/user/{appId}/{code}")
    public LoginUser getUser(@PathVariable("appId") String appId, @PathVariable("code")String code) {
        String openId = userService.getOpenId(appId, code);

        if (StringUtils.isEmpty(openId)) {
            throw new BaseException("未正确获取到用户id");
        }
        LoginUser loginUser = new LoginUser();
        SysUser sysUser = new SysUser();
        //注意，这里是工号对应登录的系统用户名
        sysUser.setUserName(openId);
        loginUser.setSysUser(sysUser);
        return loginUser;
    }
}

