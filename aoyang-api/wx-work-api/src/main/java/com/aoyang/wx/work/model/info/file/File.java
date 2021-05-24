package com.aoyang.wx.work.model.info.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : File
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 11:07
 */
@Data
public class File {
    @JsonProperty(value = "media_id")
    private String mediaId;
}
