package com.aoyang.wx.work.model.info.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : Voice
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 10:57
 */
@Data
public class Voice {
    @JsonProperty(value = "media_id")
    private String mediaId;
}
