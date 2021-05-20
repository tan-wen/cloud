package com.aoyang.wx.work.service;

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

public interface MessageService {
    WxWorkRe sendMessage(String agentId, AppletsInfo data);

    WxWorkRe sendMessage(String agentId, TextInfo data);

    WxWorkRe sendMessage(String agentId, ImageInfo data);

    WxWorkRe sendMessage(String agentId, VoiceInfo data);

    WxWorkRe sendMessage(String agentId, VideoInfo data);

    WxWorkRe sendMessage(String agentId, FileInfo data);

    WxWorkRe sendMessage(String agentId, TextCardInfo data);

    WxWorkRe sendMessage(String agentId, NewsInfo data);

    WxWorkRe sendMessage(String agentId, MarkDownInfo data);

    WxWorkRe sendMessage(String agentId, InteractiveTaskcardInfo data);
}
