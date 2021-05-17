package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.service.WxAccessService;
import com.aoyang.wx.work.service.WxWorkUserService;
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
    private WxWorkUserService wxWorkUserService;

    @GetMapping("/wx/work/user/{agentId}/{code}")
    public LoginUser getUser(@PathVariable String agentId ,@PathVariable String code) {
        return wxWorkUserService.getUser(agentId, code);
    }

}
