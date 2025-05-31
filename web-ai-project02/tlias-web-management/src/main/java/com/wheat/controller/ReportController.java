package com.wheat.controller;

import com.wheat.pojo.ClazzOption;
import com.wheat.pojo.JobOption;
import com.wheat.pojo.Result;
import com.wheat.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    /**
     * 统计员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String,Object>> genderList =  reportService.getEmpGenderData();
        
        return Result.success(genderList);
    }

    /**
     * 班级人数统计
     * {
     *   "code": 1,
     *   "msg": "success",
     *   "data": {
     *     "clazzList": ["Java就业100期","Java就业101期","Java就业102期","Java就业103期","Java就业104期"],
     *     "dataList": [77,82,70,80,90]
     *   }
     * }
     * <p>
     * ClazzOption.java
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("班级人数统计");
        //
        ClazzOption clazzOption =  reportService.getStudentCountData();
        
        return Result.success(clazzOption);
    }

    /**
     * 学员学历统计
     */
     @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("学员学历统计");
        //
        List<Map<String,Object>> degreeList =  reportService.getStudentDegreeData();
        
        return Result.success(degreeList);
    }
}
