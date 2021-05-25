package com.aoyang.wx.mp.service;

import com.ruoyi.system.api.domain.SysUser;

/**
 * @ClassName UserService
 * @description: 微信公众号用户接口
 * @author: went
 * @Date 2021/5/19 2:43 下午
 **/
public interface UserService {


    SysUser getOpenId(String appId, String code);
}
