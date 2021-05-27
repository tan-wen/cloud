package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisListFile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-27
 */
public interface BisListFileService extends IService<BisListFile> {

    Result<?> findByDetailId(String id);

}
