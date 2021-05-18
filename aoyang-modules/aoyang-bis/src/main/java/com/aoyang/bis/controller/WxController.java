package com.aoyang.bis.controller;

import com.aoyang.bis.common.wxapi.WxApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @ClassName : WxController
 * @Description : 所有和微信交互的控制器
 * @Author : GC
 * @Date: 2021-04-26 16:00
 */
@RestController
@RequestMapping("/wx")
public class WxController {

    private final WxApi wxApi;

    public WxController(WxApi wxApi) {
        this.wxApi = wxApi;
    }


    /**
     * 获取session_key和userid
     */
    @GetMapping("/login")
    public Map<String,Object> auth(@RequestParam String js_code){
        return wxApi.auth(js_code);
    }

    /**
     * 根据userid读取企业微信成员信息
     */
    @GetMapping("/getuserinfo")
    public Map<String,Object> searchUserInfo(String userid){
        return wxApi.searchUserInfo(userid);
    }






}
