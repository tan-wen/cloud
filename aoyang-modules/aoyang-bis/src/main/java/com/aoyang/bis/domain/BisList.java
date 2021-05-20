package com.aoyang.bis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  
 * </p>
 *
 * @author GC
 * @since 2021-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class BisList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 状态
     */
    private String state;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建人
     */
    private String submitter;

    /**
     * 创建人ID
     */
    private String submitterId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 浏览次数
     */
    private Integer view;

    /**
     * 顶
     */
    private Integer support;

    /**
     * 踩
     */
    private Integer unsupported;

    /**
     * 分类
     */
    private String classification;

    /**
     * 二级分类
     */
    private String secondaryClassification;


}
