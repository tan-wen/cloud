package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.common.utils.BaseUtils;
import com.aoyang.bis.common.wxapi.WxWorkApi;

import com.aoyang.bis.domain.User;
import com.aoyang.bis.domain.UserDetail;
import com.aoyang.bis.mapper.UserMapper;
import com.aoyang.bis.service.UserDetailService;
import com.aoyang.bis.service.UserService;
import com.aoyang.wx.work.model.WxWorkRe;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
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
    private WxWorkApi wxWorkApi;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserMapper userMapper;
    @Value("${agentId}")
    private String agentId;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> login() throws Exception {

        String username = SecurityUtils.getUsername();
        /**
         * 将填入用户信息和用户表，已有的将更新
         */
        //调用微信接口读取成员
        WxWorkRe workRe = wxWorkApi.getDetail(agentId, username);
        HashMap<String, Object> userinfo = (HashMap<String, Object>) workRe.data;
        UserDetail userDetail = this.buildUserDetail(userinfo);

        User user = new User();


        if(userinfo!=null &&"0".equals(userinfo.get("errcode").toString()) ){
            //创建用户
            User userf = this.findByUserId(username);
            UserDetail detail = userDetailService.findByUserId(username);
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
    public User findByUserId(String userid) {
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
