package com.aoyang.wx.work.service.remote;

import com.aoyang.wx.work.domain.WxMediaInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 素材上传
 * type	是	媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
 * 图片（image）：2MB，支持JPG,PNG格式
 * 语音（voice） ：2MB，播放长度不超过60s，仅支持AMR格式
 * 视频（video） ：10MB，支持MP4格式
 * 普通文件（file）：20MB
 */
@FeignClient(value = "WxMediaService", url = "https://qyapi.weixin.qq.com/cgi-bin/media")
public interface WxWorkMediaService {

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    WxMediaInfo upload(@RequestParam(name = "access_token") String access_token, @RequestParam(name = "type") String type, @RequestPart("filename") MultipartFile filename);

}
