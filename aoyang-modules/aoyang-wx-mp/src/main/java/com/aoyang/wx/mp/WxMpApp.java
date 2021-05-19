package com.aoyang.wx.mp;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName WxMpApplication
 * @description: 微信公众号服务
 * @author: went
 * @Date 2021/5/19 9:10 上午
 **/
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class WxMpApp {

    public static void main(String[] args) {
        SpringApplication.run(WxMpApp.class, args);
        System.out.println("微信公众号模块启动成功");
    }
}
