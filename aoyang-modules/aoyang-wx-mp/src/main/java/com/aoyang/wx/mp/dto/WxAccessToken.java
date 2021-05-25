package com.aoyang.wx.mp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * @ClassName WxAccessToken
 * @description: {"access_token":"ACCESS_TOKEN","expires_in":7200}
 * @author: went
 * @Date 2021/5/19 2:16 下午
 **/
@Data
public class WxAccessToken extends WxR {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;
}
