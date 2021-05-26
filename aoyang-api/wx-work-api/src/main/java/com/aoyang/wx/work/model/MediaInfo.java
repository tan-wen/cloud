package com.aoyang.wx.work.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : MediaInfo
 * @Description : 上传临时文件返回的ID
 * @Author : GC
 * @Date: 2021-05-26 16:39
 */
@Data
public class MediaInfo {
    @JsonProperty("media_id")
    private String mediaId;
}
