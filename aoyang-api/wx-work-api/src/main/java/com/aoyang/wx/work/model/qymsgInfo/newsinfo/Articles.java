package com.aoyang.wx.work.model.qymsgInfo.newsinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @ClassName : Articles
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 11:27
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Articles {
    private String title;
    private String description;
    private String url;
    private String picurl;
}
