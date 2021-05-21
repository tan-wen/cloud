package com.aoyang.wx.work.service;

import com.aoyang.wx.work.model.WxWorkRe;
import com.ruoyi.system.api.model.LoginUser;

/**
 * @ClassName WxWorkUserService
 * @description:
 * @author: went
 * @Date 2021/5/17 11:16 上午
 **/
public interface UserService {

    String getUser(String agentId, String code);

    String getMiniAppUser(String agentId, String code);

    WxWorkRe getuserDetail(String agentId, String userId);

}
