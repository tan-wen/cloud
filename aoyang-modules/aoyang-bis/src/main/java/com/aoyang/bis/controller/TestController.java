package com.aoyang.bis.controller;

import com.aoyang.bis.common.wxapi.WxApi;
import com.aoyang.bis.dto.Info;
import com.aoyang.bis.dto.MsgData;
import com.aoyang.bis.entity.User;
import com.aoyang.bis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : TestController
 * @Description :
 * @Author : GC
 * @Date: 2021-04-28 19:12
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final UserService userService;
    private final WxApi wxApi;

    public TestController(UserService userService, WxApi wxApi) {
        this.userService = userService;
        this.wxApi = wxApi;
    }

    @GetMapping
    public void test(@RequestBody User user){

        ArrayList<User> objects = new ArrayList<>();
        objects.add(user);
        userService.saveOrUpdateBatch(objects);
    }

    @GetMapping("/test2")
    public Map<String, Object> test2(){
        MsgData msgData = new MsgData();
        msgData.setTitle("测试");
        msgData.setTouser("AY064581");
        List<Info> list = new ArrayList<>();
        Info info = new Info();
        info.setKey("asd");
        info.setValue("aas");
        list.add(info);
        msgData.setContent_item(list);
        Map<String, Object> stringObjectMap = wxApi.sendMessage(msgData);
        return stringObjectMap;
    }




}
