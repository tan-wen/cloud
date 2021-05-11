package com.aoyang.operation.finance;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName App
 * @description: 业财融合
 * @author: went
 * @Date 2021/5/10 1:42 下午
 **/
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class OperationFinanceApp {
    public static void main(String[] args) {
        SpringApplication.run(OperationFinanceApp.class, args);
        System.out.println("业财融合模块启动成功");
    }
}
