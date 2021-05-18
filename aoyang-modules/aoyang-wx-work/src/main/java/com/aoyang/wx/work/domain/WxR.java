package com.aoyang.wx.work.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WxR
 * @description: TODO
 * @author: went
 * @Date 2021/5/18 1:10 下午
 **/
@Data
public class WxR implements Serializable {

    private Integer errcode;

    private String errmsg;
}
