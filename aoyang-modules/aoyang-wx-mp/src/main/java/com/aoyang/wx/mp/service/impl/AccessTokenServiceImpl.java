package com.aoyang.wx.mp.service.impl;

import com.aoyang.wx.mp.config.WxMps;
import com.aoyang.wx.mp.dto.WxAccessToken;
import com.aoyang.wx.mp.dto.WxOAuth2Token;
import com.aoyang.wx.mp.service.AccessTokenService;
import com.aoyang.wx.mp.service.WxMpRemoteService;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AccessTokenServiceImpl
 * @description:
 * @author: went
 * @Date 2021/5/19 2:19 下午
 **/
@Service
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {

    private static final String CACHE_PREFIX = "wx-mp-access-token";

    private static final String OAUTH2_CACHE_PREFIX = "wx-mp-oauth-token";

    private static final String CACHE_CONNECTOR = ":";

    @Resource
    private WxMpRemoteService wxMpRemoteService;

    @Resource
    private RedisService redisService;

    @Resource
    private WxMps wxMps;

    @Override
    public String getAccessToken(String appId) {

        //1、缓存中获取
        String key = CACHE_PREFIX + CACHE_CONNECTOR + appId + CACHE_CONNECTOR +  wxMps.getSecretByAppId(appId);
        final String cache = redisService.getCacheObject(key);
        if (!StringUtils.isEmpty(cache)) {
            return cache;
        }

        //2、 远程获取并存入缓存
        final WxAccessToken token = wxMpRemoteService.getToken(appId, wxMps.getSecretByAppId(appId));
        final String access_token = token.getAccess_token();
        if (access_token != null) {
            redisService.setCacheObject(key, access_token, token.getExpires_in(), TimeUnit.SECONDS);
            return access_token;
        }
        log.error("微信公众号{}获取access_token失败，{}", appId, token.getErrmsg());
        throw new BaseException("获取access-token失败。" + token.getErrmsg());
    }

    @Override
    public String refreshAccessToken(String appId) {

        String key = CACHE_PREFIX + CACHE_CONNECTOR + appId + CACHE_CONNECTOR +  wxMps.getSecretByAppId(appId);
        //移除缓存
        redisService.deleteObject(key);

        //重新获取
        return getAccessToken(appId);
    }

}
