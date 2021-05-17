package com.aoyang.wx.work.service;

import com.ruoyi.system.api.model.LoginUser;

/**
 * @ClassName WxWorkUserService
 * @description:
 * @author: went
 * @Date 2021/5/17 11:16 上午
 **/
public interface WxWorkUserService {

    LoginUser getUser(String agentId, String code);
}
