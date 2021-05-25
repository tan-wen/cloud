package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.service.UserService;
import com.ruoyi.system.api.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AuthController
 * @description: 企业微信认证
 * @author: went
 * @Date 2021/5/17 8:48 上午
 **/
@RestController
@Slf4j
@RequestMapping("/wx")
public class WxWorkUserController {

    @Resource
    private UserService wxWorkUserService;

    @GetMapping("/work/user/{agentId}/{code}")
    public SysUser getUser(@PathVariable String agentId, @PathVariable String code) {
        return wxWorkUserService.getUser(agentId, code);
    }

    @GetMapping("/miniapp/user/{agentId}/{code}")
    public SysUser getMiniAppUser(@PathVariable String agentId, @PathVariable String code) {
        return wxWorkUserService.getMiniAppUser(agentId, code);
    }

}
