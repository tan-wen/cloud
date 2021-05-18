package com.aoyang.bis.service;


import com.aoyang.bis.entity.UserOperation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-08
 */
public interface UserOperationService extends IService<UserOperation> {

    public String addInfo(String id,String type,String userId);
}
