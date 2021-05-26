package com.aoyang.wx.work.service;

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
    Boolean sendMessage(String agentId, AppletsInfo data);

    Boolean sendMessage(String agentId, TextInfo data);

    Boolean sendMessage(String agentId, ImageInfo data);

    Boolean sendMessage(String agentId, VoiceInfo data);

    Boolean sendMessage(String agentId, VideoInfo data);

    Boolean sendMessage(String agentId, FileInfo data);

    Boolean sendMessage(String agentId, TextCardInfo data);

    Boolean sendMessage(String agentId, NewsInfo data);

    Boolean sendMessage(String agentId, MarkDownInfo data);

    Boolean sendMessage(String agentId, InteractiveTaskcardInfo data);
}
