package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.Log;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import com.itheima.service.impl.LogServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LogController {
    
    private LogService logService = new LogServiceImpl();

    @RequestMapping("/logs")
    private Result list(){
        //1. 加载log.txt文件数据
        // InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        // ArrayList<String> lines = IoUtil.readUtf8Lines(inputStream, new ArrayList<String>());

        //2. 对原始数据进行处理 , 组装日志数据
        // List<Log> logList = lines.stream().map(line -> {
        //     String[] parts = line.split(",");
        //     return new Log(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
        // }).collect(Collectors.toList());
        
        List<Log> logList = logService.findAll();

        //3. 响应结果
        return Result.success(logList);
    }

}
