package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisList;
import com.aoyang.bis.dto.BisListAddDto;
import com.aoyang.bis.dto.CreatePersonList;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.time.LocalDateTime;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
public interface BisListService extends IService<BisList> {

    Result<?> findAll(String state, String submitterId, LocalDateTime createTime,String classification,String secondaryClassification) throws ParseException;

    Result<?> findCreateList(String name);

    Result<?> updateInfo(String id);

    Result<?> supportOrNot(String id, String type);

    Result<?> addBis(BisListAddDto bisListAddDto);

    Result<?> findMyList(String state, LocalDateTime createTime, String classification, String type, String secondaryClassification) throws ParseException;

    Result<?> claimBis(String id);

    Result<?> startBis(String id);

    Result<?> finishBis(String id);

    Result<?> cancelBis(String id);

    Result<?> backBis(String id);

    Result<?> assginBis(String id, CreatePersonList pseron);

    Result<?> acceptBis(String id);
}
