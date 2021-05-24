package com.aoyang.wx.work.model.info.interactivetask;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName : InteractiveTask
 * @Description :
 * @Author : GC
 * @Date: 2021-05-19 13:20
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InteractiveTaskcard {
    private String title;
    private String description;
    private String url;
    @JsonProperty(value = "task_id")
    private String taskId;
    private List<Btn> btn;

}
