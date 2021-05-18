package com.aoyang.bis.controller;

import com.aoyang.bis.common.Result;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.entity.CurrentUser;
import com.aoyang.bis.entity.Files;
import com.aoyang.bis.service.FilesService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName : FileController
 * @Description :
 * @Author : GC
 * @Date: 2021-05-07 10:11
 */

@RestController
@RequestMapping("/file")
public class FileController {

    private final FilesService filesService;

    public FileController(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostMapping
    public Result<?> FileUpLoad(HttpServletRequest request, MultipartFile file,@CurrentUser CurrentUserInfo userInfo) throws IOException {
        return filesService.addFile(request, file ,userInfo);
    }

    @GetMapping
    public Result<?> findInfoByid(@RequestParam String id){
        Files files = filesService.getById(id);
        if(files!=null){
            return Result.ok(files);
        }else {
            return Result.error(200,"未查询到信息");
        }
    }


}
