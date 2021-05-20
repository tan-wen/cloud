package com.aoyang.wx.mp.service.impl;

import com.aoyang.wx.mp.dto.TemplateMsg;
import com.aoyang.wx.mp.dto.WxMsgR;
import com.aoyang.wx.mp.dto.WxTemplateMsg;
import com.aoyang.wx.mp.service.AccessTokenService;
import com.aoyang.wx.mp.service.MsgService;
import com.aoyang.wx.mp.service.remote.WxMpMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName MsgServiceImpl
 * @author: went
 * @Date 2021/5/20 11:00 上午
 **/
@Service
public class MsgServiceImpl implements MsgService {

    @Resource
    private AccessTokenService accessTokenService;

    @Resource
    private WxMpMsgService wxMpMsgService;

    @Override
    public String sentTemplateMsg(TemplateMsg templateMsg) {
        final String token = accessTokenService.getAccessToken(templateMsg.getAppId());

        //组装模板消息
        WxTemplateMsg wxTemplateMsg = new WxTemplateMsg();
        wxTemplateMsg.setTouser(templateMsg.getOpenId());
        wxTemplateMsg.setTemplate_id(templateMsg.getTempId());
        wxTemplateMsg.setUrl(templateMsg.getUrl());
        WxTemplateMsg.MiniProgram miniProgram = new WxTemplateMsg.MiniProgram();
        miniProgram.setAppid(templateMsg.getMiniProgramAppId());
        miniProgram.setPagepath(templateMsg.getMiniProgramPagePath());
        wxTemplateMsg.setMiniprogram(miniProgram);
        wxTemplateMsg.setData(templateMsg.getContent());

        final WxMsgR wxMsgR = wxMpMsgService.sendMsg(token, wxTemplateMsg);
        if (wxMsgR.isSuccess()) {
            return wxMsgR.getMsgid();
        }
        return "";
    }
}
