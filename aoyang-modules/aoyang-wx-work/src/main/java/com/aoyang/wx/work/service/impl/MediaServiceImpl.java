package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxMediaInfo;
import com.aoyang.wx.work.model.FlagEnum;
import com.aoyang.wx.work.model.WxWorkRe;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.MediaService;
import com.aoyang.wx.work.service.remote.WxWorkMediaService;
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
public class MediaServiceImpl implements MediaService {

    @Resource
    private WxWorkMediaService workMediaService;
    @Resource
    private AccessService accessService;

    @Override
    public WxWorkRe upload(String agentId, String type, MultipartFile filename) {
        WxMediaInfo wxMediaInfo = null;
        String accessToken = accessService.getAccessToken(agentId);
        wxMediaInfo = uploadData(accessToken, type, filename);
        if (Constant.TIME_OUT_CODE.equals(wxMediaInfo.getErrcode().toString())) {
            String s = accessService.refreshAccessToken(agentId);
            wxMediaInfo = uploadData(s, type, filename);
        }
        WxWorkRe msgRe = new WxWorkRe();
        if (Constant.SUCCESS_CODE.equals(wxMediaInfo.getErrcode().toString())) {
            msgRe.flag = FlagEnum.SUCCESS.getCode();
        } else {
            msgRe.flag = FlagEnum.FAIL.getCode();
        }
        msgRe.code = wxMediaInfo.getErrcode();
        msgRe.info = wxMediaInfo.getErrmsg();
        return msgRe;

    }

    private WxMediaInfo uploadData(String accessToken, String type, MultipartFile filename) {
        return workMediaService.upload(accessToken, type, filename);
    }
}
