package com.aoyang.bis.config.exceptions;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * springboot非controller层异常处理方式,此处仅仅处理了token过期问题
// * 缺点是不能判断异常类型，可以抛出时自定义内容，在这根据内容返回。
// * 日志也可以在抛出点先行处理。
// */
//
//@RestController
//@Slf4j
//public class OtherErrorController extends BasicErrorController {
//
//
//    public OtherErrorController() {
//        super(new DefaultErrorAttributes(), new ErrorProperties());
//    }
//
//    @Override
//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        //获取异常信息
//        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));
//        if (String.valueOf(errorAttributes.get("message")).contains("token解析失败")) {
//            log.error("服务器异常,token过期" + errorAttributes.get("message"));
//            return new ResponseEntity(new HashMap<>().put("message", "token过期"), HttpStatus.UNAUTHORIZED);
//        } else {
//            log.error("服务器异常" + errorAttributes.get("message"));
//            return new ResponseEntity(errorAttributes.get("message"), (HttpStatus) errorAttributes.get("status"));
//        }
//
//    }
//}