package com.aoyang.bis.service;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.dto.BisListAddDto;
import com.aoyang.bis.dto.CreatePersonList;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.entity.BisList;
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

    Result<?> supportOrNot(String id, String type, CurrentUserInfo currentUserInfo);

    Result<?> addBis(BisListAddDto bisListAddDto, CurrentUserInfo currentUserInfo);

    Result<?> findMyList(String state, LocalDateTime createTime, String classification, String type, String secondaryClassification, CurrentUserInfo currentUserInfo) throws ParseException;

    Result<?> claimBis(String id,CurrentUserInfo currentUserInfo);

    Result<?> startBis(String id, CurrentUserInfo currentUserInfo);

    Result<?> finishBis(String id, CurrentUserInfo currentUserInfo);

    Result<?> cancelBis(String id, CurrentUserInfo currentUserInfo);

    Result<?> backBis(String id, CurrentUserInfo currentUserInfo);

    Result<?> assginBis(String id, CreatePersonList pseron, CurrentUserInfo currentUserInfo);

    Result<?> acceptBis(String id, CurrentUserInfo currentUserInfo);
}
