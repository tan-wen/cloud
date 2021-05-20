package com.aoyang.wx.work.service;

import com.aoyang.wx.work.domain.WxRInfo;
import com.aoyang.wx.work.model.qymsgInfo.appletsinfo.AppletsInfo;
import com.aoyang.wx.work.model.qymsgInfo.interactivetaskcardinfo.InteractiveTaskcardInfo;
import com.aoyang.wx.work.model.qymsgInfo.markdowninfo.MarkDownInfo;
import com.aoyang.wx.work.model.qymsgInfo.newsinfo.NewsInfo;
import com.aoyang.wx.work.model.qymsgInfo.fileinfo.FileInfo;
import com.aoyang.wx.work.model.qymsgInfo.imageinfo.ImageInfo;
import com.aoyang.wx.work.model.qymsgInfo.textcard.TextCardInfo;
import com.aoyang.wx.work.model.qymsgInfo.textinfo.TextInfo;
import com.aoyang.wx.work.model.qymsgInfo.videoinfo.VideoInfo;
import com.aoyang.wx.work.model.qymsgInfo.voiceinfo.VoiceInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 消息推送
 */
@FeignClient(value = "WxMessageService", url = "https://qyapi.weixin.qq.com/cgi-bin/message")
public interface WxMessageService {

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody AppletsInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody TextInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody ImageInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody VoiceInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody VideoInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody FileInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody TextCardInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody NewsInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody MarkDownInfo data);

    @PostMapping("/send")
    WxRInfo sendMessage(@RequestParam(name="access_token") String access_token, @RequestBody InteractiveTaskcardInfo data);


}
