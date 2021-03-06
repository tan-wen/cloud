package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxMediaInfo;
import com.aoyang.wx.work.model.MediaInfo;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.MediaService;
import com.aoyang.wx.work.service.remote.WxWorkMediaService;
import com.ruoyi.common.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName : WxWorkMediaServiceImpl
 * @Description :
 * @Author : GC
 * @Date: 2021-05-20 09:43
 */
@Service
@Slf4j
public class MediaServiceImpl implements MediaService {

    @Resource
    private WxWorkMediaService workMediaService;
    @Resource
    private AccessService accessService;

    @Override
    public MediaInfo upload(String agentId, String type, MultipartFile filename) {

        String accessToken = accessService.getAccessToken(agentId);
        WxMediaInfo wxMediaInfo = uploadData(accessToken, type, filename);
        check(wxMediaInfo.getErrCode(), wxMediaInfo.getErrMsg());
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setMediaId(wxMediaInfo.getMedia_id());
        return mediaInfo;
    }

    private WxMediaInfo uploadData(String accessToken, String type, MultipartFile filename) {
        return workMediaService.upload(accessToken, type, filename);
    }

    private void check(Integer code, String msg) {
        if (!Constant.SUCCESS_CODE.equals(code)) {
            log.error("未能正确获取微信返回，{}", msg);
            throw new BaseException("未能正确获取微信返回," + msg);
        }
    }
}
