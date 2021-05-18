package com.aoyang.bis.config.resttemplate;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

public class MsgConverter extends MappingJackson2HttpMessageConverter {
    public MsgConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        setSupportedMediaTypes(mediaTypes);// tag6
    }

}
