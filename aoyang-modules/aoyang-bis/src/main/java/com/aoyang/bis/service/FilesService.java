package com.aoyang.bis.service;


import com.aoyang.bis.common.Result;
import com.aoyang.bis.dto.CurrentUserInfo;
import com.aoyang.bis.entity.CurrentUser;
import com.aoyang.bis.entity.Files;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author GC
 * @since 2021-05-07
 */
public interface FilesService extends IService<Files> {

    Result<?> addFile(HttpServletRequest request, MultipartFile file, CurrentUserInfo userInfo) throws IOException;
}
