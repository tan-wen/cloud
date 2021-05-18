package com.aoyang.bis.service.impl;


import com.aoyang.bis.entity.UserOperation;
import com.aoyang.bis.mapper.UserOperationMapper;
import com.aoyang.bis.service.UserOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-08
 */
@Service
public class UserOperationServiceImpl extends ServiceImpl<UserOperationMapper, UserOperation> implements UserOperationService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addInfo(String id,String type,String userId) {
        UserOperation userOperation = new UserOperation();
        userOperation.setPid(id);
        userOperation.setOperationTime(LocalDateTime.now());
        userOperation.setType(type);
        userOperation.setUserId(userId);
        this.save(userOperation);
        return "success";
    }
}
