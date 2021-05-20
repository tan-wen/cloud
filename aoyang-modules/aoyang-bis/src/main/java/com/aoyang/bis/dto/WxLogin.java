package com.aoyang.bis.dto;

import com.ruoyi.common.core.utils.StringUtils;
import lombok.Data;

/**
 * @ClassName WxLogin
 * @description: 企业微信认证提交表单
 * @author: went
 * @Date 2021/5/18 1:16 下午
 **/
@Data
public class WxLogin {

    /**
     * 小应用id
     */
    private String agentId;

    /**
     * 客户端产生的code
     */
    private String code;

    public boolean hasEmpty(){
        return StringUtils.isEmpty(agentId) || StringUtils.isEmpty(code);
    }
}
