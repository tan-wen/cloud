package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxRInfo;
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
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.MessageService;
import com.aoyang.wx.work.service.remote.WxWorkMessageService;
import com.ruoyi.common.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    private WxWorkMessageService workMessageService;
    @Resource
    private AccessService accessService;

    @Override
    public Boolean sendMessage(String agentId, AppletsInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, TextInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, ImageInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, VoiceInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, VideoInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, FileInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, TextCardInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, NewsInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, MarkDownInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    @Override
    public Boolean sendMessage(String agentId, InteractiveTaskcardInfo data) {
        String accessToken = accessService.getAccessToken(agentId);
        WxRInfo wxRInfo  = workMessageService.sendMessage(accessToken, data);
        check(wxRInfo.getErrCode(),wxRInfo.getErrMsg());
        return true;
    }

    private void check(Integer code, String msg){
        if(!Constant.SUCCESS_CODE.equals(code)){
            log.error("未能正确获取微信返回，{}", msg);
            throw new BaseException("未能正确获取微信返回," + msg);
        }
    }
    
}
