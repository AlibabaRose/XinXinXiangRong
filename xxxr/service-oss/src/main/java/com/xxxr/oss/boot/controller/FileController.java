package com.xxxr.oss.boot.controller;

import com.xxxr.common.exception.BusinessException;
import com.xxxr.common.result.R;
import com.xxxr.common.result.ResponseEnum;
import com.xxxr.oss.boot.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
//@CrossOrigin
@Slf4j
@RequestMapping("/api/oss/file")
@Api(tags = "阿里云文件管理")
public class FileController {

    @Resource
    private FileService service;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public R upload(
            @ApiParam(value = "文件",required = true)
            @RequestParam MultipartFile file
            ,
            @ApiParam(value = "目录结构",required = true)
            @RequestParam("module") String module
            ){
        String filename = file.getOriginalFilename();
        String url;
        try {
            InputStream inputStream = file.getInputStream();
            url = service.upload(inputStream, module, filename);
        } catch (IOException e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR,e);
        }
        return R.ok().message("文件上传成功").data("url",url);
    }

    @ApiOperation("文件删除")
    @DeleteMapping("/remove")
    public R remove(@ApiParam("文件删除")
                                     @RequestParam String url){
        service.remove(url);
        return R.ok().message("删除文件成功");
    }
}
