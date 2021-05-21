package com.aoyang.wx.work.model;

import lombok.Data;

/**
 * @ClassName : MsgRe
 * @Description : 消息返回
 * @Author : GC
 * @Date: 2021-05-20 09:23
 */
@Data
public class WxWorkRe<T> {
    public String flag;
    public Integer code;
    public String info;
    public T data;
}
