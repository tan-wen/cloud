package com.aoyang.wx.work.service;

import com.ruoyi.system.api.domain.SysUser;
/**
 * @ClassName WxWorkUserService
 * @description:
 * @author: went
 * @Date 2021/5/17 11:16 上午
 **/
public interface UserService {

    SysUser getUser(String agentId, String code);

    SysUser getMiniAppUser(String agentId, String code);
}
