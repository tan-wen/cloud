package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.utils.BaseUtils;
import com.aoyang.bis.common.wxapi.WxApi;
import com.aoyang.bis.entity.User;
import com.aoyang.bis.entity.UserDetail;
import com.aoyang.bis.mapper.UserMapper;
import com.aoyang.bis.service.UserDetailService;
import com.aoyang.bis.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-04-28
 */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private WxApi wxApi;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> login(User user) throws Exception {
        /**
         * 将填入用户信息和用户表，已有的将更新
         */
        //调用微信接口读取成员
        Map<String, Object> userinfo = wxApi.searchUserInfo(user.getUserid());
//        if ((Integer)userinfo.get("errcode")!=0){
//            return Result.error(200,"企业微信未能查询到用户信息");
//        }
        UserDetail userDetail = this.buildUserDetail(userinfo);



        if(userinfo!=null &&"0".equals(userinfo.get("errcode").toString()) ){
            //创建用户
            User userf = this.findByuserId(user.getUserid());
            UserDetail detail = userDetailService.findByUserId(user.getUserid());
            if(userf==null){
                user.setCreateTime(LocalDateTime.now());
                userDetail.setCreateTime(LocalDateTime.now());
                if(detail!=null){
                    userDetail.setId(detail.getId());
                    userDetail.setUpdateTime(LocalDateTime.now());
                    userDetailService.updateById(userDetail);
                    this.save(user);
                }else {
                    userDetailService.save(userDetail);
                    this.save(user);
                }
            }else {
                user.setUpdateTime(LocalDateTime.now());
                user.setId(userf.getId());
                if(detail!=null){
                    userDetail.setId(detail.getId());
                    userDetail.setUpdateTime(LocalDateTime.now());
                    userDetailService.updateById(userDetail);
                    this.updateById(user);
                }else {
                    userDetail.setCreateTime(LocalDateTime.now());
                    userDetailService.save(userDetail);
                    this.updateById(user);
                }
            }
            return Result.ok(userDetail);
        }
        else {
            return Result.error(200,"未查询到用户信息,请使用正确的企业登录或联系添加成员信息");
        }
    }

    @Override
    public User findByuserId(String userid) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userid", userid);
        User one = this.getOne(userQueryWrapper);
        return one;
    }

    @Override
    public Result<?> findUsers(String name) {
       return Result.ok(userMapper.findUserList(name));
    }

    private UserDetail buildUserDetail(Map<String,Object> map) throws Exception {
        UserDetail userDetail = new UserDetail();
        BaseUtils.setFieldValue(userDetail,map);
        return userDetail;
    }
}
