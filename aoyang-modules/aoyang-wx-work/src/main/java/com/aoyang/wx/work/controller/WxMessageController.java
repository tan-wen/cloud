package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxRInfo;
import com.aoyang.wx.work.model.info.applets.AppletsInfo;
import com.aoyang.wx.work.model.info.interactivetask.InteractiveTaskcardInfo;
import com.aoyang.wx.work.model.info.markdown.MarkDownInfo;
import com.aoyang.wx.work.model.info.news.NewsInfo;
import com.aoyang.wx.work.model.info.file.FileInfo;
import com.aoyang.wx.work.model.info.image.ImageInfo;
import com.aoyang.wx.work.model.info.textcard.TextCardInfo;
import com.aoyang.wx.work.model.info.text.TextInfo;
import com.aoyang.wx.work.model.info.video.VideoInfo;
import com.aoyang.wx.work.model.info.voice.VoiceInfo;
import com.aoyang.wx.work.service.WxAccessService;
import com.aoyang.wx.work.service.WxMessageService;
import com.ruoyi.common.core.domain.R;
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
    private WxMessageService messageService;

    @Resource
    private WxAccessService wxAccessService;

    /**
     * 小程序通知消息
     * @param agentId
     * @param data
     * @return
     */
    @PostMapping("/app/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody AppletsInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/text/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody TextInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/image/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody ImageInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/voice/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody VoiceInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/video/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody VideoInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/file/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody FileInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/textcard/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody TextCardInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/news/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody NewsInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/markdown/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody MarkDownInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    @PostMapping("/interactivetaskcard/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody InteractiveTaskcardInfo data){
        String accessToken =  wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (Constant.TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),Constant.REINFO);
        }
        return R.ok(wxRInfo,Constant.REINFO);
    }

    private WxRInfo send(String accessToken, AppletsInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, TextInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, ImageInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, VoiceInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, VideoInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, FileInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, TextCardInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, NewsInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, MarkDownInfo data){
        return messageService.sendMessage(accessToken, data);
    }

    private WxRInfo send(String accessToken, InteractiveTaskcardInfo data){
        return messageService.sendMessage(accessToken, data);
    }


}
