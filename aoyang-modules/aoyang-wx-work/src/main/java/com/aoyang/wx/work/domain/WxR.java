package com.aoyang.wx.work.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WxR
 * @description:
 * @author: went
 * @Date 2021/5/18 1:10 下午
 **/
@Data
public class WxR implements Serializable {

    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;
}
