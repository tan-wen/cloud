package com.aoyang.wx.work.service;

/**
 * @ClassName WxAccessService
 * @description: 企业微信AccessToken获取
 * @author: went
 * @Date 2021/5/17 10:09 上午
 **/
public interface WxAccessService {

    String getAccessToken(String agentId);

    String refreshAccessToken(String agentId);

}
