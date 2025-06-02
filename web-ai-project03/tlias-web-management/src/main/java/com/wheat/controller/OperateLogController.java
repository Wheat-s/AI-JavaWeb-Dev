package com.wheat.controller;

import com.wheat.pojo.OperateLog;
import com.wheat.pojo.OperateLogQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.pojo.Result;
import com.wheat.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    /**
     * 日志信息的分页查询
     * 请求参数: page pageSize
     */
    @GetMapping("/page")
    public Result logPage(OperateLogQueryParam logQueryParam) {
        log.info("日志信息分页查询: {}", logQueryParam); // 日志打印
        // 
        PageResult<OperateLog> pageResult = operateLogService.page(logQueryParam);
        return Result.success(pageResult);
    }
}
