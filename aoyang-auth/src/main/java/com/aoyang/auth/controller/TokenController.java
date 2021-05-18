package com.aoyang.auth.controller;

import com.aoyang.auth.form.WxLogin;
import com.aoyang.auth.service.WxWorkUserService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private WxWorkUserService wxWorkUserService;

    // 企业微信登录认证
    @PostMapping("token/wx/work")
    public R<?> wxWorkLogin(@RequestBody WxLogin wxLogin) {
        final LoginUser user = wxWorkUserService.getWorkUser(wxLogin.getAgentId(), wxLogin.getCode());
        return R.ok(tokenService.createToken(user));
    }

    // 企业微信小程序登录认证
    @PostMapping("token/mini/program")
    public R<?> wxMiniAppLogin(@RequestBody WxLogin wxLogin) {
        final LoginUser user = wxWorkUserService.getMiniAppUser(wxLogin.getAgentId(), wxLogin.getCode());
        return R.ok(tokenService.createToken(user));
    }

    // 微信公众号登录认证
    @PostMapping("token/wx/mp")
    public R<?> wxMpLogin() {

        return R.ok();
    }

}
