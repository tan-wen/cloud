package com.aoyang.wx.work.model.info.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : Image
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 10:51
 */
@Data
public class Image {
    @JsonProperty(value = "media_id")
    private String mediaId;
}
