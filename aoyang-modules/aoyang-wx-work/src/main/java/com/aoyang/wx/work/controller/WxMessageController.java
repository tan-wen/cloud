package com.aoyang.wx.work.controller;


import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.aoyang.wx.work.model.info.file.FileInfo;
import com.aoyang.wx.work.model.info.image.ImageInfo;
import com.aoyang.wx.work.model.info.interactivetask.InteractiveTaskcardInfo;
import com.aoyang.wx.work.model.info.markdown.MarkDownInfo;
import com.aoyang.wx.work.model.info.news.NewsInfo;
import com.aoyang.wx.work.model.info.text.TextInfo;
import com.aoyang.wx.work.model.info.textcard.TextCardInfo;
import com.aoyang.wx.work.model.info.video.VideoInfo;
import com.aoyang.wx.work.model.info.voice.VoiceInfo;
import com.aoyang.wx.work.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @ClassName : WxMessageController
 * @Description : 消息推送
 * @Author : GC
 * @Date: 2021-05-19 08:16
 */
@RestController
@RequestMapping("/msg")
@Slf4j
public class WxMessageController {

    @Resource
    private MessageService messageService;


    /**
     * 小程序通知消息
     *
     * @param agentId
     * @param data
     * @return
     */
    @PostMapping("/app/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody AppletsInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/text/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody TextInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/image/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody ImageInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/voice/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody VoiceInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/video/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody VideoInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/file/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody FileInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/textcard/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody TextCardInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/news/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody NewsInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/markdown/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody MarkDownInfo data) {
        return messageService.sendMessage(agentId, data);
    }

    @PostMapping("/interactivetaskcard/{agentId}")
    public Boolean sendMessage(@PathVariable String agentId, @RequestBody InteractiveTaskcardInfo data) {
        return messageService.sendMessage(agentId, data);
    }




}
