package com.aoyang.wx.work.model.info.interactivetask;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : Btn
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 13:22
 */
@Data
public class Btn {
    private String key;
    private String name;
    private String color;
    @JsonProperty(value = "is_bold")
    private Boolean isBold;
}
