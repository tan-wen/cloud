package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.wxapi.WxSystemApi;
import com.aoyang.bis.common.wxapi.WxWorkApi;
import com.aoyang.bis.service.UserService;
import com.aoyang.wx.work.model.TagMember;
import com.aoyang.wx.work.model.WxUserInfo;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private WxWorkApi wxWorkApi;
    @Autowired
    private WxSystemApi wxSystemApi;

    @Value("${agentId}")
    private String agentId;

    @Value("${tagId}")
    private String tagId;

    @Override
    public Result<?> findUsers(String name) {
        TagMember tagMember = wxWorkApi.findTagMember(agentId, tagId);
        List<WxUserInfo> userlist = tagMember.getUserlist();
        if (StringUtils.isNotEmpty(name)) {
            userlist = userlist.stream().filter(v -> v.getName().contains(name)).collect(Collectors.toList());
        }
        return Result.ok(userlist);
    }

    @Override
    public Result<?> findByUserId(String username) {
        SysUser usreInfo = wxSystemApi.findUsreInfo(username);
        System.out.println(usreInfo);
        return Result.ok(usreInfo);
    }


}
