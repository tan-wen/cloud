package com.aoyang.bis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserOperation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private String id;

    /**
     * pid
     */
    private String pid;

    /**
     * 用户userId
     */
    private String userId;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;

    /**
     * 备注
     */
    private String remarks;


}
