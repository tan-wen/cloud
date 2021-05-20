package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.service.UserDetailService;
import com.aoyang.bis.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName : LoginController
 * @Description :bis系统登陆,在获取token后用于调用微信接口获取用户详情以及保存用户主信息
 * @Author : GC
 * @Date: 2021-04-27 15:09
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserDetailService userDetailService;
    private final UserService userService;

    public LoginController(UserDetailService userDetailService, UserService userService) {
        this.userDetailService = userDetailService;
        this.userService = userService;
    }

    @PostMapping
    public Result<?> login() throws Exception {
        //创建用户
        return userService.login();
    }



}
