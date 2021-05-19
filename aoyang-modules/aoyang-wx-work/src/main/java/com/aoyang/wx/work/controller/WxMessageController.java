package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.domain.WxRInfo;
import com.aoyang.wx.work.model.qymsgInfo.appletsinfo.AppletsInfo;
import com.aoyang.wx.work.model.qymsgInfo.interactivetaskcardinfo.InteractiveTaskcardInfo;
import com.aoyang.wx.work.model.qymsgInfo.markdowninfo.MarkDown;
import com.aoyang.wx.work.model.qymsgInfo.markdowninfo.MarkDownInfo;
import com.aoyang.wx.work.model.qymsgInfo.newsinfo.NewsInfo;
import com.aoyang.wx.work.model.qymsgInfo.textcard.TextCard;
import com.aoyang.wx.work.model.qymsgInfo.fileinfo.FileInfo;
import com.aoyang.wx.work.model.qymsgInfo.imageinfo.ImageInfo;
import com.aoyang.wx.work.model.qymsgInfo.textcard.TextCardInfo;
import com.aoyang.wx.work.model.qymsgInfo.textinfo.TextInfo;
import com.aoyang.wx.work.model.qymsgInfo.videoinfo.VideoInfo;
import com.aoyang.wx.work.model.qymsgInfo.voiceinfo.VoiceInfo;
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

    private final String TIME_OUT_CODE = "40001";

    private final String reinfo="已调用";

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
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/text/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody TextInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/image/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody ImageInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/voice/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody VoiceInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/video/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody VideoInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/file/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody FileInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/textcard/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody TextCardInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/news/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody NewsInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/markdown/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody MarkDownInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
    }

    @PostMapping("/interactivetaskcard/{agentId}")
    public R<?> sendMessage(@PathVariable String agentId, @RequestBody InteractiveTaskcardInfo data){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxRInfo wxRInfo = send(accessToken, data);
        if (TIME_OUT_CODE.equals(wxRInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(send(s, data),reinfo);
        }
        return R.ok(wxRInfo,reinfo);
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
