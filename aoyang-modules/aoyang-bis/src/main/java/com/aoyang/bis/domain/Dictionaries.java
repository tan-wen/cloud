package com.aoyang.bis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class Dictionaries implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 分类代码
     */
    private String typecode;

    /**
     * 上级id
     */
    private String superiorId;

    /**
     * 字段代码
     */
    private String code;

    /**
     * 中文名
     */
    private String name;


}
