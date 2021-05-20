package com.aoyang.wx.mp.controller;

import com.aoyang.wx.mp.dto.TemplateMsg;
import com.aoyang.wx.mp.service.MsgService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MsgController
 * @description: 微信公众号消息控制器
 * @author: went
 * @Date 2021/5/20 1:27 下午
 **/
@RestController
@RequestMapping("/wx/mp/msg")
public class MsgController {

    @Resource
    private MsgService msgService;

    @PostMapping("/template")
    public String sendTemplateMsg(TemplateMsg msg) {
        return msgService.sentTemplateMsg(msg);
    }
}
