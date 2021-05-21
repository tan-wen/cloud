package com.aoyang.auth.service;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName SysUserService
 * @description: TODO
 * @author: went
 * @Date 2021/5/21 4:29 下午
 **/
@FeignClient(ServiceNameConstants.SYSTEM_SERVICE)
public interface SysUserService {

    @PostMapping("/getOrInsert/{username}")
    SysUser getOrInsert(@PathVariable String username);
}
