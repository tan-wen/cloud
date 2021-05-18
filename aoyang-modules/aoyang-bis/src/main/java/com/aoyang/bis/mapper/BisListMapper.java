package com.aoyang.bis.mapper;

import com.aoyang.bis.dto.CreatePersonList;
import com.aoyang.bis.entity.BisList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *   Mapper 接口
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@Repository
public interface BisListMapper extends BaseMapper<BisList> {

    List<CreatePersonList> findCreateList(String name);

    List<BisList> findMyCharge(String state, String chargePersonId, String start, String end, String classification, String secondaryClassification);

    List<BisList> findAllInfo(String state, String userId, String start, String end, String classification, String secondaryClassification);
}

