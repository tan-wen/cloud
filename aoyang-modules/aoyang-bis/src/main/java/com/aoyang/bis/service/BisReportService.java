package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.entity.BisDetail;
import com.aoyang.bis.entity.BisReport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
public interface BisReportService extends IService<BisReport> {

    Result<?> findByPid(String id);

    Result<?> addinfo(BisReport bisReport, CurrentUserInfo currentUserInfo);
}
