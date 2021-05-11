package com.aoyang.exhibition;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName fair
 * @description: 展销会
 * @author: went
 * @Date 2021/5/11 1:34 下午
 **/
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class ExhibitionFairApp {

    public static void main(String[] args) {
        SpringApplication.run(ExhibitionFairApp.class, args);
        System.out.println("展销会模块启动成功");
    }

}
