package com.aoyang.wx.mp.controller;

import com.aoyang.wx.mp.service.UserService;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @description: 微信公众号用户控制器
 * @author: went
 * @Date 2021/5/19 1:16 下午
 **/
@RestController
@RequestMapping("/wx/mp/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{appId}/{code}")
    public SysUser getUser(@PathVariable("appId") String appId, @PathVariable("code") String code) {
        return userService.getOpenId(appId, code);
    }
}

