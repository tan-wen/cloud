package com.aoyang.bis.common.wxapi;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : WxSystemApi
 * @Description :
 * @Author : GC
 * @Date: 2021-05-26 15:47
 */

@FeignClient(value = ServiceNameConstants.SYSTEM_SERVICE)
public interface WxSystemApi {

    @GetMapping("/user/userinfo/{username}")
    SysUser findUsreInfo(@PathVariable(value = "username") String username);

}
