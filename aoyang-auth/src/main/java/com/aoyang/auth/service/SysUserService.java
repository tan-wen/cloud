package com.aoyang.auth.service;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName SysUserService
 * @description: TODO
 * @author: went
 * @Date 2021/5/21 4:29 下午
 **/
@FeignClient(ServiceNameConstants.SYSTEM_SERVICE)
public interface SysUserService {

    @PostMapping("/user/getOrInsert/{username}")
    SysUser getOrInsert(@PathVariable(value="username") String username);

    @PostMapping("/user/getOrInsert")
    SysUser getOrInsert(@RequestBody SysUser sysUser);
}
