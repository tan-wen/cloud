package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.entity.Dictionaries;
import com.aoyang.bis.mapper.DictionariesMapper;
import com.aoyang.bis.service.DictionariesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : DictionariesServiceImpl
 * @Description :
 * @Author : GC
 * @Date: 2021-05-05 08:58
 */
@Service
public class DictionariesServiceImpl extends ServiceImpl<DictionariesMapper, Dictionaries> implements DictionariesService {


    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> saveInfo(Dictionaries dictionaries) {
        QueryWrapper<Dictionaries> wrapper = new QueryWrapper<>();
        wrapper.eq("code",dictionaries.getCode());
        Dictionaries one = this.getOne(wrapper);
        if(one!=null){
            return Result.error(200,"该字典代码已存在");
        }else {
            this.save(dictionaries);
            return Result.ok();
        }
    }

    @Override
    public Result<?> findByInfo(String code) {
        QueryWrapper<Dictionaries> wrapper = new QueryWrapper<>();
        wrapper.eq("code",code);
        Dictionaries one = this.getOne(wrapper);
        if(one!=null){
            return Result.ok(one);
        }else {
            return Result.error(200,"未查询到该信息");
        }
    }

    @Override
    public Result<?> findBySuperiorId(String superiorId) {
        QueryWrapper<Dictionaries> wrapper = new QueryWrapper<>();
        wrapper.eq("superior_id",superiorId);
        List<Dictionaries> dictionaries = dictionariesMapper.selectList(wrapper);
        return Result.ok(dictionaries);
    }

    @Override
    public Result<?> findByTypeCode(String typecode) {
        QueryWrapper<Dictionaries> wrapper = new QueryWrapper<>();
        wrapper.eq("typecode",typecode);
        List<Dictionaries> dictionaries = dictionariesMapper.selectList(wrapper);
        return Result.ok(dictionaries);
    }
}
