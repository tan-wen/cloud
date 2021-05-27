package com.aoyang.bis.service.impl;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisListFile;
import com.aoyang.bis.mapper.BisListFileMapper;
import com.aoyang.bis.service.BisListFileService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-27
 */
@Service
public class BisListFileServiceImpl extends ServiceImpl<BisListFileMapper, BisListFile> implements BisListFileService {

    @Autowired
    private BisListFileMapper bisListFileMapper;

    @Override
    public Result<?> findByDetailId(String id) {
        QueryWrapper<BisListFile> wrapper = new QueryWrapper<>();
        wrapper.eq("detail_id",id);
        List<BisListFile> bisListFiles = bisListFileMapper.selectList(wrapper);
        return Result.ok(bisListFiles);
    }
}
