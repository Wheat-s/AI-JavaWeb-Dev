package com.wheat.controller;

import com.wheat.pojo.Emp;
import com.wheat.pojo.PageResult;
import com.wheat.pojo.Result;
import com.wheat.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    
    @Autowired
    private EmpService empService;
    
    /**
     * 分页查询
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, 
                       @RequestParam(defaultValue = "10"    ) Integer pageSize) {
        log.info("分页查询: page={}, pageSize={}", page, pageSize);
        PageResult<Emp> pageResult = empService.page(page, pageSize);
        
        return Result.success(pageResult);
    }
}
