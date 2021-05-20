package com.aoyang.wx.work.model.info.news;

import lombok.Data;

import java.util.List;


/**
 * @ClassName : News
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 11:26
 */

@Data
public class News {
    private List<Articles> articles;
}
