package com.aoyang.wx.mp.service;

/**
 * @ClassName UserService
 * @description: 微信公众号用户接口
 * @author: went
 * @Date 2021/5/19 2:43 下午
 **/
public interface UserService {


    String getOpenId(String appId, String code);
}
