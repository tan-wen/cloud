package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : GC
 * @Date: 2021-05-11 19:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result<?> findAll(@RequestParam(required = false) String name){
        return userService.findUsers(name);
    }

}
