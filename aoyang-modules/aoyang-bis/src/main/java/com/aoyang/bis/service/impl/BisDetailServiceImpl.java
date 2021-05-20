package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisDetail;
import com.aoyang.bis.mapper.BisDetailMapper;
import com.aoyang.bis.service.BisDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@Service
public class BisDetailServiceImpl extends ServiceImpl<BisDetailMapper, BisDetail> implements BisDetailService {

    @Override
    public Result<?> findByPid(String pid) {
        QueryWrapper<BisDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",pid);
        BisDetail bisDetail = this.getOne(wrapper);
        return Result.ok(bisDetail);
    }
}
