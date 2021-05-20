package com.aoyang.wx.work.model.info.applets;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @ClassName : MiniprogramNotice
 * @Description : 消息体
 * @Author : GC
 * @Date: 2021-05-19 09:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MiniprogramNotice {
    private String appid;
    private String page;
    private String title;
    private String description;
    private String emphasis_first_item;
    private List<ContentItem> content_item;



}
