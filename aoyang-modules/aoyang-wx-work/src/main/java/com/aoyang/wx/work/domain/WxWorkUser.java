package com.aoyang.wx.work.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WxWorkUser
 * @description: 企业微信用户
 * @author: went
 * @Date 2021/5/17 2:21 下午
 **/
@Data
public class WxWorkUser implements Serializable {

    //工号
    private String userid;

    //姓名
    private String name;

    //邮箱
    private String email;

    //手机号
    private String mobile;
}
