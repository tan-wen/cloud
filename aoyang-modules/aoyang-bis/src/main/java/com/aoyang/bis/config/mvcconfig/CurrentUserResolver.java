//package com.aoyang.bis.config.mvcconfig;
//
//import com.aoyang.bis.common.utils.ReadFileUtil;
//import com.aoyang.bis.dto.CurrentUserInfo;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//import javax.servlet.http.HttpServletRequest;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.PublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.X509EncodedKeySpec;
//import org.apache.commons.codec.binary.Base64;
//
//@Component
//public class CurrentUserResolver implements HandlerMethodArgumentResolver {
//
//    @Value("${jwt.publicKeyPath}")
//    private String pubkeyPath;
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.getParameterAnnotation(CurrentUser.class) != null && parameter.getParameterType() == CurrentUserInfo.class;
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
//        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if (StringUtils.isBlank(authorization) || authorization.startsWith("Authorization")) {
//            //此处返回空，没有认证应该返回401
//            return new CurrentUserInfo();
//        }
//
//        String token = authorization.replace("Bearer", "");
//
//        String pubkey = ReadFileUtil.readToString(pubkeyPath, "");
//        PublicKey publicKey = getPublicKey(pubkey);
//
//        Claims claims = Jwts.parser()
//                .setSigningKey(publicKey)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return CurrentUserInfo.builder()
//                .userid((String)claims.get("userid"))
//                .name((String)claims.get("name"))
//                .mobile((String)claims.get("mobile"))
//                .deviceid((String)claims.get("deviceid"))
//                .build();
//    }
//
//    private static PublicKey getPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        byte[] keyBytes = Base64.decodeBase64(key);
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        return publicKey;
//    }
//}
