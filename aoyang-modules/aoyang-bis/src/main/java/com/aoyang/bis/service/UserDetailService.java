package com.aoyang.bis.service;


import com.aoyang.bis.entity.UserDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */
public interface UserDetailService extends IService<UserDetail> {

    UserDetail findByUserId(String userid);
}
