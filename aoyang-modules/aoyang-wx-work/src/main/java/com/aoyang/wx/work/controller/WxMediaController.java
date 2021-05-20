package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.domain.WxMediaInfo;
import com.aoyang.wx.work.service.WxAccessService;
import com.aoyang.wx.work.service.WxMediaService;
import com.ruoyi.common.core.domain.R;
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

    private final String TIME_OUT_CODE = "40001";

    private final String reinfo="已调用";

    @Resource
    private WxMediaService wxMediaService;
    @Resource
    private WxAccessService wxAccessService;

    @PostMapping("/upload/{agentId}/{type}")
    public R<?> upload(@PathVariable String agentId,@PathVariable String type, MultipartFile filename){
        String accessToken = wxAccessService.getAccessToken(agentId);
        WxMediaInfo wxMediaInfo = uploadData(accessToken,type,filename);
        if (TIME_OUT_CODE.equals(wxMediaInfo.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(uploadData(s,type,filename),reinfo);
        }
        return R.ok(wxMediaInfo,reinfo);
    }

    private WxMediaInfo uploadData(String accessToken,String type,MultipartFile filename){
        return wxMediaService.upload(accessToken,type, filename);
    }



}
