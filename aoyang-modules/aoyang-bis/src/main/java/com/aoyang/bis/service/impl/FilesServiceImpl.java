package com.aoyang.bis.service.impl;


import com.aoyang.bis.common.Result;
import com.aoyang.bis.domain.Files;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.mapper.FilesMapper;
import com.aoyang.bis.service.FilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.utils.SecurityUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author GC
 * @since 2021-05-07
 */
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, Files> implements FilesService {

    @Value("${file.upload}")
    private String uploadpath;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> addFile(HttpServletRequest request, MultipartFile file) throws IOException {

        // 获取文件夹路径【static/upload/2020/03/05】
        String path = uploadpath + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        // 判断并创建文件夹
        File myfile = new File(path);
        if (!myfile.exists()) {
            myfile.mkdirs();//创一个文件夹
        }
        // 获取后缀名【.jpg】
        String name = file.getOriginalFilename();
        String Suffix = name.substring(name.lastIndexOf("."), name.length());
        // 获取文件名
        String uuidname = UUID.randomUUID() +"_"+ Suffix;
        // 保存文件
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, uuidname));

        String url ="/"+path+"/"+uuidname;
        Files files = new Files();
        String id =UUID.randomUUID().toString().replace("-","");
        files.setId(id);
        files.setUrl(url);
        files.setFilename(name);
        files.setCreateTime(LocalDateTime.now());
        files.setCreatePersonId(SecurityUtils.getUsername());

        this.save(files);
        return Result.ok(files);
    }

}
