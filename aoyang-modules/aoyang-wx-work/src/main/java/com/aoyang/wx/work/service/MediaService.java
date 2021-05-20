package com.aoyang.wx.work.service;

import com.aoyang.wx.work.model.WxWorkRe;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    WxWorkRe upload(String agentId, String type, MultipartFile filename);
}
