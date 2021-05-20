package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
public interface BisDetailService extends IService<BisDetail> {

    Result<?> findByPid(String pid);
}
