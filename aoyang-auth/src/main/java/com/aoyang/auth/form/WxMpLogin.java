package com.aoyang.auth.form;

import com.ruoyi.common.core.utils.StringUtils;
import lombok.Data;

/**
 * @ClassName WxMpLogin
 * @description: 微信公众号认证认证提交表单
 * @author: went
 * @Date 2021/5/19 2:50 下午
 **/
@Data
public class WxMpLogin {

    /**
     * 公众号id
     */
    private String appId;

    /**
     * 客户端生成的code
     */
    private String code;

    public boolean hasEmpty() {
        return StringUtils.isEmpty(appId) || StringUtils.isEmpty(code);
    }
}
