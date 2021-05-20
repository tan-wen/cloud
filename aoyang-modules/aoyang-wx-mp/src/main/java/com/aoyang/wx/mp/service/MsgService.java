package com.aoyang.wx.mp.service;

import com.aoyang.wx.mp.dto.TemplateMsg;

/**
 * @ClassName MsgService
 * @description: 微信公众号消息推送接口
 * @author: went
 * @Date 2021/5/20 10:51 上午
 **/
public interface MsgService {

    /**
     * 发送模板消息
     * @return 消息id
     */
    String sentTemplateMsg(TemplateMsg templateMsg);
}
