package com.aoyang.bis.config.resttemplate;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @ClassName : MyInterceptor
 * @Description :
 * @Author : GC
 * @Date: 2021-05-14 16:02
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        System.out.println(new String(body));

        return execution.execute(request, body);
    }
}
