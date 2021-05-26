package com.aoyang.wx.work.domain;

import com.aoyang.wx.work.model.WxUserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;


/**
 * @ClassName : TagMember
 * @Description :标签成员
 * @Author : GC
 * @Date: 2021-05-26 14:39
 */
@Data
public class WxTagMember extends WxR {

    //标签名
    @JsonProperty("tagname")
    private String tagName;

    //标签成员列表
    private List<WxUserInfo> userlist;

    //标签部门ID
    private Object partylist;




}
