package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.model.WxWorkRe;
import com.aoyang.wx.work.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : WxUserDetailController
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 16:32
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class WxUserDetailController {

    @Resource
    private UserService userService;


    @GetMapping("/{agentId}/{userId}")
    public WxWorkRe getUserDetail(@PathVariable String agentId, @PathVariable String userId) {
        return userService.getuserDetail(agentId, userId);
    }

}
