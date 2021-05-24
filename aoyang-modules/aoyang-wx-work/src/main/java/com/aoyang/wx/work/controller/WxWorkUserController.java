package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.model.WxWorkRe;
import com.aoyang.wx.work.service.UserService;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class WxWorkUserController {

    @Resource
    private UserService wxWorkUserService;

    @GetMapping("/wx/work/user/{agentId}/{code}")
    public String getUser(@PathVariable String agentId ,@PathVariable String code) {
        return wxWorkUserService.getUser(agentId, code);
    }

    @GetMapping("/wx/miniapp/user/{agentId}/{code}")
    public String getMiniAppUser(@PathVariable String agentId ,@PathVariable String code) {
        return wxWorkUserService.getMiniAppUser(agentId, code);
    }

    @GetMapping("/wx/miniapp/detail/{agentId}/{code}")
    public SysUser getMiniAppUserDetail(@PathVariable String agentId, @PathVariable String code) {
        return wxWorkUserService.getMiniAppUserDetail(agentId,code);
    }





}
