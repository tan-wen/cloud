package com.aoyang.bis.controller;


import com.aoyang.bis.common.Result;
import com.aoyang.bis.entity.Dictionaries;
import com.aoyang.bis.service.DictionariesService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author GC
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/dictionaries")
public class DictionariesController {

    private final DictionariesService dictionariesService;

    public DictionariesController(DictionariesService dictionariesService) {
        this.dictionariesService = dictionariesService;
    }

    @PostMapping("/add")
    public Result<?> addInfo(@RequestBody Dictionaries dictionaries){
        return  dictionariesService.saveInfo(dictionaries);
    }
    /**
     * 根据分类代码查询
     */
    @GetMapping("/typecode")
    public Result<?> findByType(@RequestParam String typecode){
        return  dictionariesService.findByTypeCode(typecode);
    }

    /**
     * 根据上级ID查询
     * @param superiorId
     * @return
     */
    @GetMapping("/superior")
    public Result<?> findBySuperiorId(@RequestParam String superiorId){
        return  dictionariesService.findBySuperiorId(superiorId);
    }

    /**
     * 根据code查询单个
     * @param code
     * @return
     */
    @GetMapping("/code")
    public Result<?> findByCode(@RequestParam String code){
        return  dictionariesService.findByInfo(code);
    }

}

