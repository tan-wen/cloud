package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */
public interface UserService extends IService<User> {
    Result<?> login(User user) throws Exception;

    User findByuserId(String id);

    Result<?> findUsers(String name);
}
