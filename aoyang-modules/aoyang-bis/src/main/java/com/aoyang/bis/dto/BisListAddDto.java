package com.aoyang.bis.dto;

import lombok.Data;

/**
 * @ClassName : BisListDto
 * @Description : 用于新建一个Bis
 * @Author : GC
 * @Date: 2021-05-11 14:53
 */
@Data
public class BisListAddDto {


    /**
     * 标题
     */
    private String title;

    /**
     * 分类
     */
    private String classification;

    /**
     * 二级分类
     */
    private String secondaryClassification;

    /**
     * 描述
     */
    private String describeInfo;

    /**
     * 重要程度
     */
    private String importance;

    /**
     * 紧急程度
     */
    private String urgency;

    /**
     * 处理意向人
     */
    private String intention;

    /**
     * 处理意向人UserID
     */
    private String intentionId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 图片id逗号分隔
     */
    private String pictureids;


}
