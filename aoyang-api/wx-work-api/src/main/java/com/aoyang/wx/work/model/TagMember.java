package com.aoyang.wx.work.model;

import lombok.Data;

import java.util.List;

/**
 * @ClassName : TagMember
 * @Description : 返回标签成员
 * @Author : GC
 * @Date: 2021-05-26 16:55
 */
@Data
public class TagMember {
    private List<WxUserInfo> userlist;
}
