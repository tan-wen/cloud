package com.aoyang.wx.work.domain;

import lombok.Data;

/**
 * @ClassName : WxMediaInfo
 * @Description : 上传文件返回
 * @Author : GC
 * @Date: 2021-05-19 13:55
 */
@Data
public class WxMediaInfo extends WxR{
    private String type;
    private String media_id;
    private String created_at;
}
