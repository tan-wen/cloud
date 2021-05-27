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
public class BisDetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 主表ID
     */
    private String pid;

    /**
     * 标题
     */
    private String title;

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
     * 负责人
     */
    private String chargePerson;

    /**
     * 负责人UserID
     */
    private String chargePersonId;

    /**
     * 指派人
     */
    private String designator;

    /**
     * 指派人UserID
     */
    private String designatorId;

    /**
     * 指派时间
     */
    private LocalDateTime assignedTime;

    /**
     * 处理意向人
     */
    private String intention;

    /**
     * 处理意向人UserID
     */
    private String intentionId;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 完成时间
     */
    private LocalDateTime endTime;

    /**
     * 去向
     */
    private String way;

    /**
     * 备注
     */
    private String remarks;



}
