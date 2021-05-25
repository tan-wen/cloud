package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxMediaInfo;
import com.aoyang.wx.work.model.WxWorkRe;
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
            msgRe.flag = true;
        } else {
            msgRe.flag = false;
        }
        check(msgRe.flag,wxMediaInfo.getErrmsg());
        msgRe.code = wxMediaInfo.getErrcode();
        msgRe.info = wxMediaInfo.getErrmsg();
        return msgRe;

    }

    private WxMediaInfo uploadData(String accessToken, String type, MultipartFile filename) {
        return workMediaService.upload(accessToken, type, filename);
    }

    private void check(Boolean flag,String msg){
        if(!flag){
            log.error("未能正确获取微信返回，{}", msg);
            throw new BaseException("未能正确获取微信返回," + msg);
        }
    }
}
