package com.wheat.controller;

import com.wheat.pojo.Result;
import com.wheat.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    /**
     * 本地磁盘存储方案
     */
    /*@PostMapping("/upload")
    public Result upload(String name, String age, MultipartFile file) throws IOException {
        log.info("文件上传中...{},{},{}",  name, age, file);
        // 获取上传的文件名
        String originalFilename = file.getOriginalFilename();
        String extention = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extention;
        
        // 保存文件
        file.transferTo(new File("/Users/wheat/Downloads/" + newFileName));
        return Result.success();
    }*/
    
    /**
     * 阿里云OSS存储方案
     */
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        // 打印文件信息
        log.info("文件上传:{}", file.getOriginalFilename());
        // 将文件交给阿里云OSS服务进行存储
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        // 打印文件存储的url
        log.info("文件上传成功, url:{}", url);
        
        return Result.success(url);
    }
}
