package com.aoyang.wx.work.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : WxUserInfo
 * @Description : 标签成员信息
 * @Author : GC
 * @Date: 2021-05-26 14:46
 */
@Data
public class WxUserInfo {

    @JsonProperty("userid")
    private String userId;
    private String name;
}
