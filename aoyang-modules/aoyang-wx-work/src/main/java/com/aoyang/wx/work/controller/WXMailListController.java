package com.aoyang.wx.work.controller;

import com.aoyang.wx.work.model.TagMember;
import com.aoyang.wx.work.service.MailListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @ClassName : WXMailListController
 * @Description : 通讯录管理
 * @Author : GC
 * @Date: 2021-05-26 14:17
 */
@RestController
@RequestMapping("/maillist")
@Slf4j
public class WXMailListController {

    @Resource
    private MailListService mailListService;

    @GetMapping("/{agentId}/{tagId}")
    private TagMember findTagMember(@PathVariable String agentId, @PathVariable String tagId){
        return mailListService.findTagMember(agentId,tagId);
    }

}
