package com.aoyang.wx.work.service.impl;


import com.aoyang.wx.work.config.WxWork;
import com.aoyang.wx.work.domain.AccessToken;
import com.aoyang.wx.work.service.AccessService;
import com.aoyang.wx.work.service.remote.WxWorkService;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName WxAccessServiceImpl
 * @author: went
 * @Date 2021/5/17 10:10 上午
 **/
@Service
@Slf4j
public class AccessServiceImpl implements AccessService {

    private static final String CACHE_PREFIX = "wx-work-access-token";

    private static final String CACHE_CONNECTOR = ":";

    @Resource
    private WxWork wxWork;

    @Resource
    private WxWorkService wxWorkRemoteService;

    @Resource
    private RedisService redisService;

    @Override
    public String getAccessToken(String agentId) {

        //先从Redis中尝试获取 key = wx-work-access-token:appId:agentId
        String key = CACHE_PREFIX + CACHE_CONNECTOR + wxWork.getAppId() + CACHE_CONNECTOR +  agentId;
        final String cache = redisService.getCacheObject(key);
        if (!StringUtils.isEmpty(cache)) {
            return cache;
        }

        //远程获取accessToken
        final AccessToken accessToken = wxWorkRemoteService.getAccessToken(
                wxWork.getAppId(), wxWork.getSecretByAgentId(agentId));

        if (accessToken.getErrCode().equals(0)) {
            final String access_token = accessToken.getAccess_token();
            redisService.setCacheObject(key,
                    access_token,
                    accessToken.getExpires_in(),
                    TimeUnit.SECONDS);
            return access_token;
        }
        log.error("获取access_token失败，{}", accessToken.getErrMsg());
        throw new BaseException("获取access-token失败。" + accessToken.getErrMsg());
    }

    @Override
    public String refreshAccessToken(String agentId) {
        String key = CACHE_PREFIX + CACHE_CONNECTOR + wxWork.getAppId() + CACHE_CONNECTOR +  agentId;

        //移除缓存
        redisService.deleteObject(key);

        //重新获取
        return getAccessToken(agentId);
    }
}
