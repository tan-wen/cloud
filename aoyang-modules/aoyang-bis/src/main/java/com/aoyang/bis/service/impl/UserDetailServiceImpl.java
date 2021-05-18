package com.aoyang.bis.service.impl;

import com.aoyang.bis.entity.UserDetail;
import com.aoyang.bis.mapper.UserDetailMapper;
import com.aoyang.bis.service.UserDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {


    @Override
    public UserDetail findByUserId(String userid) {
        QueryWrapper<UserDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        return this.getOne(queryWrapper);
    }
}
