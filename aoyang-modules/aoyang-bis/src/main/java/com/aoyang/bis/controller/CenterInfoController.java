package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.service.UserDetailService;
import com.ruoyi.common.core.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : CenterInfoController
 * @Description : 个人中心
 * @Author : GC
 * @Date: 2021-04-29 13:10
 */
@RestController
@RequestMapping("/center")
public class CenterInfoController {

    private final UserDetailService userDetailService;

    public CenterInfoController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public Result<?> searchInfo(){
        String username = SecurityUtils.getUsername();
        return Result.ok(userDetailService.findByUserId(username));
    }
}
