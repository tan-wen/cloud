package com.aoyang.bis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *  
 * </p>
 *
 * @author GC
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BisListFile implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private String id;

    /**
     * 详情表ID
     */
    private String detailId;

    /**
     * URL
     */
    private String url;


}
