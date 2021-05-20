package com.aoyang.wx.mp.dto;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName BaseMsg
 * @description: 微信公众号模板消息封装
 * @author: went
 * @Date 2021/5/20 11:25 上午
 **/
@Data
public class TemplateMsg {

    /**
     * 微信公众号appId
     */
    private String appId;

    /**
     * 微信用户在公众号中对应的openId
     */
    private String openId;

    /**
     * 模板消息id
     */
    private String tempId;

    /**
     * 消息点击后跳转的url地址
     */
    private String url;

    /**
     * 小程序appId，配置后点击消息跳转至指定小程序
     */
    private String miniProgramAppId;

    /**
     * 跳转至小程序的指定页面
     */
    private String miniProgramPagePath;

    /**
     * 推送的模块消息内容，key为模块中的占位符
     */
    private Map<String, Object> content;
}
