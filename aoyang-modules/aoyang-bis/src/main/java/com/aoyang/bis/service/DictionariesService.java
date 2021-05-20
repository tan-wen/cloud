package com.aoyang.bis.service;


import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.Dictionaries;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-05
 */
public interface DictionariesService extends IService<Dictionaries> {

    Result<?> saveInfo(Dictionaries dictionaries);

    Result<?> findByInfo(String code);

    Result<?> findBySuperiorId(String superiorId);

    Result<?> findByTypeCode(String typecode);

}
