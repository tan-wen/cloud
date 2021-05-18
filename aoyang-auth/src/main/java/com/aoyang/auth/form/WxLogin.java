package com.aoyang.auth.form;

import lombok.Data;

/**
 * @ClassName WxLogin
 * @description: TODO
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
}
