package com.aoyang.wx.work.domain;

import lombok.Data;

/**
 * @ClassName : WxRInfo
 * @Description :
 * 如果部分接收人无权限或不存在，发送仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag），常见的原因是接收人不在应用的可见范围内。
 * 如果全部接收人无权限或不存在，则本次调用返回失败，errcode为81013。
 * 返回包中的userid，不区分大小写，统一转为小写
 * @Author : GC
 * @Date: 2021-05-19 10:08
 */
@Data
public class WxRInfo extends WxR {
    private String invaliduser;
    private String invalidparty;
    private String invalidtag;
}
