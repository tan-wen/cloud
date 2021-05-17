package com.aoyang.auth.controller;

import com.aoyang.auth.service.WxWorkRemoteService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TokenController
 * @description:
 * @author: went
 * @Date 2021/5/17 9:55 上午
 **/
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Resource
    private WxWorkRemoteService wxWorkRemoteService;

    // 企业微信登录认证
    @GetMapping("wx/work/token/{agentId}/{code}")
    public R<?> wxWorkLogin(@PathVariable String agentId, @PathVariable String code) {
        final LoginUser user = wxWorkRemoteService.getUser(agentId, code);
        return R.ok(tokenService.createToken(user));
    }

    // 微信公众号登录认证
    @PostMapping("wx/mp/login")
    public R<?> wxMpLogin() {

        return R.ok();
    }

}
