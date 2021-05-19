package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.domain.UserDetail;
import com.aoyang.wx.work.domain.WxMediaInfo;
import com.aoyang.wx.work.domain.WxRInfo;
import com.aoyang.wx.work.service.WxAccessService;
import com.aoyang.wx.work.service.WxWorkRemoteService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * @ClassName : WxUserDetailController
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 16:32
 */
@RestController
@RequestMapping("/userdetail")
@Slf4j
public class WxUserDetailController {

    private final String TIME_OUT_CODE = "40001";

    private final String reinfo="已调用";

    @Resource
    private WxAccessService wxAccessService;

    @Resource
    private WxWorkRemoteService wxWorkRemoteService;

    @GetMapping
    public R<?> getUserDetail(@RequestParam String agentId, @RequestParam String userId) {
        String accessToken = wxAccessService.getAccessToken(agentId);
        UserDetail userDetail = findUserDetail(accessToken, userId);
        if (TIME_OUT_CODE.equals(userDetail.getErrcode())){
            String s = wxAccessService.refreshAccessToken(agentId);
            return R.ok(findUserDetail(s, userId),reinfo);
        }
        return R.ok(userDetail,reinfo);
    }

    private UserDetail findUserDetail(String accessToken, String userId){
        return wxWorkRemoteService.getUserDetail(accessToken,userId);
    }

}
