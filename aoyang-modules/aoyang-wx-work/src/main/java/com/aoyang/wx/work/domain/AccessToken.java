package com.aoyang.wx.work.domain;

import lombok.Data;

/**
 * @ClassName AccessToken
 * @description: https://open.work.weixin.qq.com/api/doc/90000/90135/91039
 *  {
 *    "errcode": 0,
 *    "errmsg": "ok",
 *    "access_token": "accesstoken000001",
 *    "expires_in": 7200
 *  }
 * @author: went
 * @Date 2021/5/17 3:56 下午
 **/
@Data
public class AccessToken extends WxR{

    private String access_token;

    private Long expires_in;
}
