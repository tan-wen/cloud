package com.aoyang.wx.work.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName MinAppUser
 * @description: https://open.work.weixin.qq.com/api/doc/90000/90136/91507
 *
 * //正常返回的JSON数据包
 * {
 *       "corpid": "CORPID",
 *       "userid": "USERID",
 *       "session_key": "kJtdi6RF+Dv67QkbLlPGjw==",
 *       "errcode": 0,
 *       "errmsg": "ok"
 * }
 * //错误时返回JSON数据包(示例为Code无效)
 * {
 *     "errcode": 40029,
 *     "errmsg": "invalid code"
 * }
 * @author: went
 * @Date 2021/5/18 11:23 上午
 **/
@Data
public class MinAppUser extends WxR {

    private String corpid;

    private String userid;

    private String session_key;

}
