package com.aoyang.bis.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @ClassName : CurrentUserInfo
 * @Description :
 * @Author : GC
 * @Date: 2021-04-28 16:01
 */
@Data
@Builder
public class CurrentUserInfo {
    @Tolerate
    public CurrentUserInfo(){
    }
    private String userid;
    private String mobile;
    private String name;
    private String deviceid;
}
