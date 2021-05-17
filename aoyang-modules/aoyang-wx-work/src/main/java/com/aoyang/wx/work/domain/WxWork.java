package com.aoyang.wx.work.domain;

import com.ruoyi.common.core.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName WxWork
 * @description: TODO
 * @author: went
 * @Date 2021/5/17 1:18 下午
 **/
@Component
@ConfigurationProperties(prefix = "wx.work")
@Data
@Slf4j
public class WxWork {

    private String appId;

    private List<Agent> agents;

    @Data
    public static class Agent {

        private String name;

        private String agentId;

        private String secret;
    }

    public String getSecretByAgentId(String agentId) {
        if (StringUtils.isEmpty(agentId)) {
            log.warn("入参agentId不能为空");
            return "";
        }
        for (Agent agent : agents) {
            if (agentId.equals(agent.getAgentId())) {
                return agent.getSecret();
            }
        }
        log.warn("未找到agentId = {}的配置", agentId);
        return "";
    }
}
