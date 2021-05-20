package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.service.BisDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    public BisDetailController(BisDetailService bisDetailService) {
        this.bisDetailService = bisDetailService;
    }

    @GetMapping("/finddetail")
    private Result<?> findDetail(@RequestParam String pid){
       return bisDetailService.findByPid(pid);
    }

}

