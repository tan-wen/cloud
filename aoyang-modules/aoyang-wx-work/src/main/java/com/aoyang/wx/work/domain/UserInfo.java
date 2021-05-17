package com.aoyang.wx.work.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName UserInfo
 * @description: https://open.work.weixin.qq.com/api/doc/90000/90135/91023
 *  {
 *    "errcode": 0,
 *    "errmsg": "ok",
 *    "UserId":"USERID",
 *    "DeviceId":"DEVICEID"
 * }
 * 或者
 * {
 *    "errcode": 0,
 *    "errmsg": "ok",
 *    "OpenId":"OPENID",
 *    "DeviceId":"DEVICEID",
 *    "external_userid":"EXTERNAL_USERID"
 * }
 *
 * @author: went
 * @Date 2021/5/17 4:53 下午
 **/
@Data
public class UserInfo {

    private Integer errcode;

    private String errmsg;

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("DeviceId")
    private String deviceId;

    //为外部员工时返回的参数
    @JsonProperty("OpenId")
    private String openId;

    //为外部员工时返回的参数
    private String external_userid;

}
