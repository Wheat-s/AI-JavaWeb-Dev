package com.wheat.controller;

import com.wheat.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    
    @PostMapping("/upload")
    public Result upload(String name, String age, MultipartFile file) throws IOException {
        log.info("文件上传中...{},{},{}",  name, age, file);
        // 获取上传的文件名
        String originalFilename = file.getOriginalFilename();
        String extention = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extention;
        
        // 保存文件
        file.transferTo(new File("/Users/wheat/Downloads/" + newFileName));
        return Result.success();
    }
}
