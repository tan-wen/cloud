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
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 成员UserID 关联user表该字段
     */
    private String userid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 成员所属部门ID列表
     */
    private String department;

    /**
     * 职务信息
     */
    private String position;

    /**
     * 性别
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 在所在部门是否为上级
     */
    private String isLeaderInDept;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 头像缩略图url
     */
    private String thumbAvatar;

    /**
     * 座机
     */
    private String telephone;

    /**
     * 别名
     */
    private String alias;

    /**
     * 扩展属性
     */
    private String extattr;

    /**
     * 激活状态 1=已激活，2=已禁用，4=未激活，5=退出企业。
     */
    private Integer status;

    /**
     * 员工个人二维码
     */
    private String qrCode;

    /**
     * 成员对外属性
     */
    private String externalProfile;

    /**
     * 对外职务
     */
    private String externalPosition;

    /**
     * 地址
     */
    private String address;

    /**
     * open_userid 全局唯一。对于同一个服务商，不同应用获取到企业内同一个成员的open_userid是相同的
     */
    private String openUserid;

    /**
     * 主部门
     */
    private String mainDepartment;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;





}
