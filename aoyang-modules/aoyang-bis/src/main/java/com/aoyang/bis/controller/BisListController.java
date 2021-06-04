package com.aoyang.bis.controller;


import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.BisList;
import com.aoyang.bis.domain.StatusEnum;
import com.aoyang.bis.dto.BisListAddDto;
import com.aoyang.bis.dto.CreatePersonList;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.service.BisListService;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDateTime;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author GC
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/bis-list")
public class BisListController {

    private final BisListService bisListService;

    public BisListController(BisListService bisListService) {
        this.bisListService = bisListService;
    }


    @GetMapping("/list")
    public Result<?> findList(@RequestParam(required = false) String state,
                              @RequestParam(required = false) String submitterId,
                              @RequestParam(required = false) LocalDateTime createTime,
                              @RequestParam(required = false) String classification,
                              @RequestParam(required = false) String secondaryClassification) throws ParseException {
        return bisListService.findAll(state, submitterId, createTime, classification, secondaryClassification);
    }

    /**
     * type  这里指查询我提出的还是我负责的 "0"我提出的，"1"我负责的
     */
    @GetMapping("/mylist/charge")
    public Result<?> findMyCommitList(@RequestParam(required = false) String state,
                                @RequestParam(required = false) LocalDateTime createTime,
                                @RequestParam(required = false) String classification,
                                @RequestParam(required = false) String secondaryClassification
    ) throws ParseException {
        return bisListService.findMyList(state, createTime, classification,"1", secondaryClassification);
    }

    @GetMapping("/mylist/commit")
    public Result<?> findMyChargeList(@RequestParam(required = false) String state,
                                @RequestParam(required = false) LocalDateTime createTime,
                                @RequestParam(required = false) String classification,
                                @RequestParam(required = false) String secondaryClassification
    ) throws ParseException {
        return bisListService.findMyList(state, createTime, classification,"0", secondaryClassification);
    }

    /**
     * 我管理的，只显示未处理的
     * @param submitterId
     * @param createTime
     * @param classification
     * @param secondaryClassification
     * @return
     * @throws ParseException
     */
    @GetMapping("/control")
    public Result<?> findList(@RequestParam(required = false) String submitterId,
                              @RequestParam(required = false) LocalDateTime createTime,
                              @RequestParam(required = false) String classification,
                              @RequestParam(required = false) String secondaryClassification) throws ParseException {
        return bisListService.findAll(StatusEnum.UNPROCESSED.getCode(), createTime, classification, secondaryClassification);
    }


    @GetMapping("/findbyid")
    public Result<?> findById(@RequestParam String id) {
        BisList bisList = bisListService.getById(id);
        return Result.ok(bisList);
    }

    @GetMapping("/createman")
    public Result<?> findCreateList(@RequestParam(required = false) String name) {
        return bisListService.findCreateList(name);
    }

    /**
     * 增加浏览次数
     */
    @PutMapping("/addbrowse")
    public Result<?> browseAdd(@RequestParam String id){
        return bisListService.updateInfo(id);
    }

    /**
     * 顶和踩
     */
    @PutMapping("/support")
    public Result<?> supportOrNot(@RequestParam String id, @RequestParam String type) {
        return bisListService.supportOrNot(id, type);
    }

    /**
     * 添加Bis
     * @param bisListAddDto
     * @return
     */
    @PostMapping("/addone")
    public Result<?> addOne(@RequestBody BisListAddDto bisListAddDto) {
        return bisListService.addBis(bisListAddDto);
    }

    /**
     * 认领Bis
     */
    @PutMapping("/claim/{id}")
    public Result<?> claimBis(@PathVariable String id){
        return bisListService.claimBis(id);
    }

    /**
     * 开始Bis
     */
    @PutMapping("/start/{id}")
    public Result<?> startBis(@PathVariable String id){
        return bisListService.startBis(id);
    }

    /**
     * 完成Bis
     */
    @PutMapping("/finish/{id}")
    public Result<?> finishBis(@PathVariable String id){
        return bisListService.finishBis(id);
    }

    /**
     *  驳回Bis
     */
    @PutMapping("/back/{id}")
    public Result<?> backBis(@PathVariable String id){
        return bisListService.backBis(id);
    }

    /**
     * 取消Bis
     */
    @PutMapping("/cancel/{id}")
    public Result<?> cancelBis(@PathVariable String id){
        return bisListService.cancelBis(id);
    }

    /**
     * 指派Bis
     */
    @PutMapping("/assgin/{id}")
    public Result<?> assginBis(@PathVariable String id, @RequestBody CreatePersonList pseron){
        return bisListService.assginBis(id,pseron);
    }

    /**
     * 接受Bis
     */
    @PutMapping("/accept/{id}")
    public Result<?> acceptBis(@PathVariable String id){
        return bisListService.acceptBis(id);
    }

    /**
     * 转派Bis
     */
    @PutMapping("/trans/{id}")
    public Result<?> transBis(@PathVariable String id, @RequestBody CreatePersonList pseron){
        return bisListService.transBis(id,pseron);
    }

}

