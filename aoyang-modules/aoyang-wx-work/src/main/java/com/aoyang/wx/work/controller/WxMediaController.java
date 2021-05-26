package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.model.MediaInfo;
import com.aoyang.wx.work.service.MediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

/**
 * @ClassName : WxMediaController
 * @Description : 临时文件上传
 * @Author : GC
 * @Date: 2021-05-19 13:49
 */

@RestController
@RequestMapping("/media")
@Slf4j
public class WxMediaController {

    @Resource
    private MediaService mediaService;

    @PostMapping("/upload/{agentId}/{type}")
    public MediaInfo upload(@PathVariable String agentId, @PathVariable String type, MultipartFile filename) {
        return mediaService.upload(agentId, type, filename);
    }

}
