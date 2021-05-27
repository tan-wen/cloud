package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */
public interface UserService  {
    Result<?> findUsers(String name);

    Result<?> findByUserId(String username);

}
