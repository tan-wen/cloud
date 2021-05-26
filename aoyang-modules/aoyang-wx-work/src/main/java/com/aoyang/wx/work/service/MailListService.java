package com.aoyang.wx.work.service;


import com.aoyang.wx.work.model.TagMember;

public interface MailListService {
    TagMember findTagMember(String agentId, String tagId);
}
