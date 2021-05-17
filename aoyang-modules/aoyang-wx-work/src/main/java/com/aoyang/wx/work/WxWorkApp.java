package com.aoyang.wx.work;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName WxWorkApp
 * @description: 启动类
 * @author: went
 * @Date 2021/5/17 8:44 上午
 **/
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class WxWorkApp {

    public static void main(String[] args) {
        SpringApplication.run(WxWorkApp.class, args);
    }
}
