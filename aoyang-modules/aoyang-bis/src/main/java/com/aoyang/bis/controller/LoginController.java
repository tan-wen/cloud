package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.entity.User;
import com.aoyang.bis.service.UserDetailService;
import com.aoyang.bis.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;


/**
 * @ClassName : LoginController
 * @Description :bis系统登陆
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
    public Result<?> login(@RequestBody User user) throws Exception {
        //创建用户
        return userService.login(user);
    }



}
