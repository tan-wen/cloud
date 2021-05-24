package com.aoyang.wx.work.model.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : base
 * @Description : 基本信息列表，详见每个具体Info体注释
 * @Author : GC
 * @Date: 2021-05-19 08:56
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Base {
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    @JsonProperty(value = "enable_duplicate_check")
    private Integer enableDuplicateCheck;
    @JsonProperty(value = "duplicate_check_interval")
    private Integer duplicateCheckInterval;
}
