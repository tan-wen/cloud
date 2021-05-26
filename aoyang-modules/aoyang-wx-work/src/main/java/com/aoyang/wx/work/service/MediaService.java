package com.aoyang.wx.work.service;


import com.aoyang.wx.work.model.MediaInfo;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    MediaInfo upload(String agentId, String type, MultipartFile filename);
}
