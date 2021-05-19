package com.aoyang.wx.mp.config;

import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.common.core.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName WxMp
 * @description: yml配置文件中读取公众号
 * @author: went
 * @Date 2021/5/19 1:47 下午
 **/
@Component
@ConfigurationProperties(prefix = "wx")
@Data
@Slf4j
public class WxMps {

    private List<WxMp> mps;

    @Data
    public static class WxMp {

        private String appId;

        private String name;

        private String secret;
    }

    public String getSecretByAppId(String appId) {
        if (StringUtils.isEmpty(appId)) {
            log.error("appId不能为空");
            throw new BaseException("appId不能为空");
        }
        for (WxMp mp : mps) {
            if (appId.equals(mp.appId)) {
                return mp.secret;
            }
        }
        throw new BaseException("未查询到appId为 "+ appId +" 的配置");
    }
}
