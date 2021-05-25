package com.aoyang.wx.work.model;

import lombok.Data;

/**
 * @ClassName : MsgRe
 * @Description : 若返回值未抽取到API则返回该对象,对于大多数需要返回对象的情况应当将对象一并抽取到API层。
 * @Author : GC
 * @Date: 2021-05-20 09:23
 */
@Data
public class WxWorkRe<T> {
    public Boolean flag;
    public Integer code;
    public String info;
    public T data;
}
