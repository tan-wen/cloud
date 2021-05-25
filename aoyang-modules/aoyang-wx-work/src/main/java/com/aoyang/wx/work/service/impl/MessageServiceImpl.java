package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxRInfo;
import com.aoyang.wx.work.model.WxWorkRe;
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
    public WxWorkRe sendMessage(String agentId, AppletsInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, TextInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, ImageInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, VoiceInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, VideoInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, FileInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, TextCardInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, NewsInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, MarkDownInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    @Override
    public WxWorkRe sendMessage(String agentId, InteractiveTaskcardInfo data) {
        WxRInfo wxRInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxRInfo = workMessageService.sendMessage(accessToken, data);

        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxRInfo.getErrcode().toString())) {
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxRInfo.getErrmsg());
        msgRe.code = wxRInfo.getErrcode();
        msgRe.info = wxRInfo.getErrmsg();
        return msgRe;
    }

    private void check(Boolean flag,String msg){
        if(!flag){
            log.error("未能正确获取微信返回，{}", msg);
            throw new BaseException("未能正确获取微信返回," + msg);
        }
    }


}
