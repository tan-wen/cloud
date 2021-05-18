package com.aoyang.bis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import java.io.IOException;
import java.security.*;


@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("classpath:wx.yml")
@PropertySource("classpath:wxinterface.yml")
@MapperScan(basePackages = {"com.aoyang.bis.mapper"})
public class BisApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        SpringApplication.run(BisApplication.class, args);


//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        SecureRandom secureRandom = new SecureRandom("112233aa!~".getBytes());
//        keyPairGenerator.initialize(1024, secureRandom);
//        KeyPair keyPair = keyPairGenerator.genKeyPair();
//        PublicKey aPublic = keyPair.getPublic();
//        PrivateKey aPrivate = keyPair.getPrivate();
//
//        System.out.println("+start+++++++++++++++");
//        System.out.println(Base64.encodeBase64String(aPrivate.getEncoded()));
//        System.out.println("+end+++++++++++++++");
//        System.out.println("+start+++++++++++++++");
//        System.out.println(Base64.encodeBase64String(aPublic.getEncoded()));
//        System.out.println("+end+++++++++++++++");
    }

}
