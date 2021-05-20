package com.aoyang.bis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BisReport implements Serializable {

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
     * 留言内容
     */
    private String info;

    /**
     * 留言人USERID（用于普通留言）
     */
    private String commenterId;

    /**
     * 留言者姓名
     */
    private String name;

    /**
     * 回复人USERID（用于人家评论你）
     */
    private String reportId;

    /**
     * 回复人姓名
     */
    private String reportName;

    /**
     * 留言时间
     */
    private LocalDateTime createTime;


}
