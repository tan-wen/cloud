package com.aoyang.wx.mp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName WxTemplateMsg
 * @description: 微信公众号模板消息
 *  url和miniprogram都是非必填字段，若都不传则模板无跳转；
 *  若都传，会优先跳转至小程序。开发者可根据实际需要选择其中一种跳转方式即可。
 *  当用户的微信客户端版本不支持跳小程序时，将会跳转至url
 * @author: went
 * @Date 2021/5/20 10:43 上午
 **/
@Data
public class WxTemplateMsg implements Serializable {

    private String touser;

    private String template_id;

    private String url;

    private MiniProgram miniprogram;

    private Map<String, Object> data;

    @Data
    public static class MiniProgram implements Serializable {

        private String appid;

        private String pagepath;
    }
}
