package com.aoyang.wx.work.model.info.applets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "appid")
    private String appId;
    private String page;
    private String title;
    private String description;
    @JsonProperty(value = "emphasis_first_item")
    private String emphasisFirstItem;
    @JsonProperty(value = "content_item")
    private List<ContentItem> contentItem;



}
