package com.aoyang.wx.mp.dto;

import com.aoyang.wx.mp.config.Constants;
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

    public boolean isSuccess () {
        return Constants.SUCCESS_CODE.equals(errCode);
    }
}
