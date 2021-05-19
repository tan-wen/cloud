package com.aoyang.auth.controller;

import com.aoyang.auth.form.WxLogin;
import com.aoyang.auth.form.WxMpLogin;
import com.aoyang.auth.service.WxMpUserService;
import com.aoyang.auth.service.WxWorkUserService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
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

    @Resource
    private WxMpUserService wxMpUserService;

    // 企业微信登录认证
    @PostMapping("token/wx/work")
    public R<?> wxWorkLogin(@RequestBody WxLogin wxLogin) {
        if (wxLogin.hasEmpty()) {
            R.fail("参数不能为空");
        }
        final LoginUser user = wxWorkUserService.getWorkUser(wxLogin.getAgentId(), wxLogin.getCode());
        return R.ok(tokenService.createToken(user));
    }

    // 企业微信小程序登录认证
    @PostMapping("token/mini/program")
    public R<?> wxMiniAppLogin(@RequestBody WxLogin wxLogin) {
        if (wxLogin.hasEmpty()) {
            R.fail("参数不能为空");
        }
        final LoginUser user = wxWorkUserService.getMiniAppUser(wxLogin.getAgentId(), wxLogin.getCode());
        return R.ok(tokenService.createToken(user));
    }

    // 微信公众号登录认证
    @PostMapping("token/wx/mp")
    public R<?> wxMpLogin(@RequestBody WxMpLogin wxMpLogin) {
        if (wxMpLogin.hasEmpty()) {
            R.fail("参数不能为空");
        }
        final LoginUser user = wxMpUserService.getUser(wxMpLogin.getAppId(), wxMpLogin.getCode());
        return R.ok(tokenService.createToken(user));
    }

}
