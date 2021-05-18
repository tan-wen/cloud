package com.aoyang.bis.mapper;

import com.aoyang.bis.dto.UsersDto;
import com.aoyang.bis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *   Mapper 接口
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */
public interface UserMapper extends BaseMapper<User> {

    List<UsersDto> findUserList(String name);
}
