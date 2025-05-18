package com.wheat.controller;

import com.wheat.pojo.Clazz;
import com.wheat.pojo.Result;
import com.wheat.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 查询所有班级
     * 
     * 基本信息
     * 请求路径：/clazzs/list
     * 请求方式：GET
     * 接口描述：该接口用于查询所有班级信息
     * 
     * 请求参数
     * 无
     * 
     * 响应数据
     * 参数格式：application/json
     */
    @GetMapping("/list")
    public Result list() {
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success();
    }
    
}
