package com.aoyang.auth.service;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName WxMpUserService
 * @description: 微信公众号用户远程服务
 * @author: went
 * @Date 2021/5/19 9:01 上午
 **/
@FeignClient(value = ServiceNameConstants.AOYANG_WX_MP)
public interface WxMpUserService {

    @GetMapping("/wx/mp/user/{appId}/{code}")
    LoginUser getUser(@PathVariable("appId") String appId, @PathVariable("code")String code);
}
