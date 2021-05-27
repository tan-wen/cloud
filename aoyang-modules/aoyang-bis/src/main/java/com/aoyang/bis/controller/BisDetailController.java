package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.service.BisDetailService;
import com.aoyang.bis.service.BisListFileService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/bis-detail")
public class BisDetailController {

    private final BisDetailService bisDetailService;

    private final BisListFileService bisListFileService;

    public BisDetailController(BisDetailService bisDetailService, BisListFileService bisListFileService) {
        this.bisDetailService = bisDetailService;
        this.bisListFileService = bisListFileService;
    }

    @GetMapping("/finddetail")
    private Result<?> findDetail(@RequestParam String pid){
       return bisDetailService.findByPid(pid);
    }

    @GetMapping("/{id}")
    public Result<?> findFiles(@PathVariable String id){
       return bisListFileService.findByDetailId(id);
    }

}

