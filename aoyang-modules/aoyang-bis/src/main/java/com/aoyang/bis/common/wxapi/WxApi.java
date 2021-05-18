package com.aoyang.bis.common.wxapi;

import com.aoyang.bis.dto.MsgData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : WxApi
 * @Description :
 * @Author : GC
 * @Date: 2021-04-28 13:31
 */
@Component
public class WxApi {

    private String access_token;

    @Value("${secret}")
    private String secret;
    @Value("${companyid}")
    private String companyId;
    @Value("${access_token}")
    private String access_token_url;
    @Value("${session_key}")
    private String session_key_url;
    @Value("${user_info}")
    private String user_info_url;
    @Value("${msg_push}")
    private String msg_push_url;
    @Value("${appid}")
    private String appid;

    private final RestTemplate restTemplate;


    public WxApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 定时获取企业微信的access_token
     */
    @Scheduled(fixedDelayString = "${schedule.runner.vtsinfo.fixedDelay}", initialDelayString = "${schedule.runner.vtsinfo.initialDelay}")
    public void getCompanyAccessToken(){
        HashMap<String, String> request = new HashMap<>();
        request.put("corpid",companyId);
        request.put("corpsecret",secret);

        Map forObject = restTemplate.getForObject(access_token_url, Map.class, request);
        Object access_token = forObject.get("access_token");

        if(access_token!=null&& StringUtils.isNotEmpty(access_token.toString())){
            this.access_token =forObject.get("access_token").toString();
        }else {
            throw new RuntimeException("小程序获取access_token失败错误码："+ forObject.get("errcode").toString()+"错误信息："+ forObject.get("errmsg").toString());
        }
    }

    /**
     * 获取session_key和userid
     */
    public Map<String,Object> auth(@RequestParam String js_code){
        HashMap<String, String> request = new HashMap<>();
        request.put("access_token",access_token);
        request.put("code",js_code);
        return restTemplate.getForObject(session_key_url, Map.class, request);
    }

    /**
     * 根据userid读取企业微信成员信息
     */
    public Map<String,Object> searchUserInfo(String userid){
        HashMap<String, String> request = new HashMap<>();
        request.put("access_token",access_token);
        request.put("userid",userid);
        return restTemplate.getForObject(user_info_url, Map.class, request);
    }

    /**
     * 消息推送
     */
    public Map<String,Object> sendMessage(MsgData data){
        HashMap<String, Object> request = new HashMap<>();
        request.put("access_token",access_token);
        HashMap<String, Object> map = new HashMap();
        map.put("msgtype","miniprogram_notice");
        map.put("touser",data.getTouser());
        HashMap<String, Object> insidemap = new HashMap<>();
        insidemap.put("appid",appid);
        insidemap.put("page",data.getPage());
        insidemap.put("title",data.getTitle());
        insidemap.put("content_item",data.getContent_item());
        map.put("miniprogram_notice",insidemap);
        HttpEntity<HashMap<String, Object>> entity = new HttpEntity<>(map);
        HashMap<String, Object> body = entity.getBody();
        return restTemplate.exchange(msg_push_url, HttpMethod.POST, entity, Map.class, request).getBody();
    }




}
