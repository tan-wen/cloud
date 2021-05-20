package com.aoyang.wx.work.model.info.video;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @ClassName : Video
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 11:00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Video {
    private String title;
    private String media_id;
    private String description;
}
