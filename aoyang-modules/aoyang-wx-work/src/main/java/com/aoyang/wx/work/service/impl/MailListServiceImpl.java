package com.aoyang.wx.work.service.impl;

import com.aoyang.wx.work.config.Constant;
import com.aoyang.wx.work.domain.WxTagMember;
import com.aoyang.wx.work.model.TagMember;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.MailListService;
import com.aoyang.wx.work.service.remote.WxWorkTagService;
import com.ruoyi.common.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : MailListServiceImpl
 * @Description :
 * @Author : GC
 * @Date: 2021-05-26 14:28
 */
@Service
@Slf4j
public class MailListServiceImpl implements MailListService {

    @Resource
    private WxWorkTagService wxWorkTagService;
    @Resource
    private AccessService accessService;

    @Override
    public TagMember findTagMember(String agentId, String tagId) {
        String accessToken = accessService.getAccessToken(agentId);
        WxTagMember wxTagMember = wxWorkTagService.getTagUser(accessToken, tagId);
        check(wxTagMember.getErrCode(),wxTagMember.getErrMsg());
        TagMember tagMember = new TagMember();
        tagMember.setUserlist(wxTagMember.getUserlist());
        return tagMember;
    }

    private void check(Integer code, String msg){
        if(!Constant.SUCCESS_CODE.equals(code)){
            log.error("未能正确获取微信返回，{}", msg);
            throw new BaseException("未能正确获取微信返回," + msg);
        }
    }
}
