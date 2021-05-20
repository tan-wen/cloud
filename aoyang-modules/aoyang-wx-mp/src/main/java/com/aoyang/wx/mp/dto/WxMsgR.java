package com.aoyang.wx.mp.dto;

import lombok.Data;

/**
 * @ClassName WxMsgR
 * @description: 微信公众号消息返回值
 * @author: went
 * @Date 2021/5/20 10:40 上午
 **/
@Data
public class WxMsgR extends WxR{

    private String msgid;
}
