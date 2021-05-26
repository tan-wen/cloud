package com.aoyang.wx.work.service.remote;

import com.aoyang.wx.work.domain.WxTagMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通讯录管理
 */
@FeignClient(value = "WxWorkTagService", url = "https://qyapi.weixin.qq.com/cgi-bin/tag")
public interface WxWorkTagService {
    @GetMapping("/get")
    WxTagMember getTagUser(@RequestParam(name = "access_token") String accessToken,
                           @RequestParam(name = "tagid") String tagId);
}
