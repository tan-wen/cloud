package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisReport;
import com.aoyang.bis.service.BisReportService;
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
@RequestMapping("/bis-report")
public class BisReportController {

    private final BisReportService bisReportService;

    public BisReportController(BisReportService bisReportService) {
        this.bisReportService = bisReportService;
    }

    @GetMapping
    public Result<?> findReport(@RequestParam String pid){
        return bisReportService.findByPid(pid);
    }

    @PostMapping
    public Result<?> addReport(@RequestBody BisReport bisReport){
        return bisReportService.addinfo(bisReport);
    }

}

