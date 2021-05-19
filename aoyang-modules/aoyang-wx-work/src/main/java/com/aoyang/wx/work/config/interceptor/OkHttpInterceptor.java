package com.aoyang.wx.work.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName : OkHttpInterceptor
 * @Description : 用于拦截feign发出的请求
 * @Author : GC
 * @Date: 2021-05-19 10:34
 */
@Component
public class OkHttpInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println(requestTemplate.body());
    }
}
