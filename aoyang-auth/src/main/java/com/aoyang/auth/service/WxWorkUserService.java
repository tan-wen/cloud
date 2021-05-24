package com.aoyang.auth.service;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName WxAccessService
 * @description: 企业微信AccessToken获取
 * @author: went
 * @Date 2021/5/17 10:09 上午
 **/

@FeignClient(value = ServiceNameConstants.AOYANG_WX_WORK)
public interface WxWorkUserService {

    @GetMapping("/wx/work/user/{agentId}/{code}")
    String getWorkUser(@PathVariable(value = "agentId") String agentId,
                      @PathVariable(value = "code") String code);

    @GetMapping("/wx/miniapp/user/{agentId}/{code}")
    String getMiniAppUser(@PathVariable(value = "agentId") String agentId,
                             @PathVariable(value = "code") String code);

    @GetMapping("/wx/miniapp/detail/{agentId}/{code}")
    SysUser getMiniAppUserDetail(@PathVariable(value = "agentId") String agentId,
                                 @PathVariable(value = "code") String code);
}
