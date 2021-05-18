package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.utils.ReadFileUtil;
import com.aoyang.bis.dto.Token;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

/**
 * @ClassName : TokenController
 * @Description : 用来获取token
 * @Author : GC
 * @Date: 2021-04-28 15:26
 */
@RestController
@RequestMapping("/auth")
public class TokenController {

    @Value("${jwt.privateKeyPath}")
    private String privateKeyPath;

    @PostMapping
    public Result<?> buildToken(@RequestBody HashMap<String,Object> map) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String token = buildToken(map, privateKeyPath);
        return Result.ok(new Token(token));
    }

    public static String buildToken(Map<String, Object> info, String privateKeyPath) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String privateKey = ReadFileUtil.readToString(privateKeyPath, "");
        PrivateKey prk = getPrivateKey(privateKey);
        JwtBuilder jwtBuilder = Jwts.builder();
        info.forEach((k, v) -> {
            jwtBuilder.claim(k, v);
        });
        return jwtBuilder.signWith(SignatureAlgorithm.RS256, prk).compact();
    }

    public static PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] keyBytes = Base64.decodeBase64(key);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        return privateKey;
    }
}
