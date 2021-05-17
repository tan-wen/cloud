package com.aoyang.auth;

import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName AoYangAuthApp
 * @description: 认证授权中心
 * @author: went
 * @Date 2021/5/17 9:52 上午
 **/
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AoYangAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AoYangAuthApp.class, args);
        System.out.println("AoYang认证授权中心启动成功。");
    }
}
