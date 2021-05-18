package com.aoyang.bis.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : MsgData
 * @Description : 企业微信消息推送实体，仅封装部分参数
 * @Author : GC
 * @Date: 2021-05-14 13:21
 */
@Data
public class MsgData {


    /**
     * 成员ID列表 ，多个接收者用‘|’分隔，最多支持1000个
     */
    private String touser;

    /**
     * 点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
     */
    private String page;

    /**
     * 标题 4~12长度
     */
    private String title;

    /**
     *消息内容键值对，最多允许10个item,
     *            content_item: [{
     *                 "key": "会议室",
     *                 "value": "402"
     *             }]
     */
    private  List<Info> content_item;

}
