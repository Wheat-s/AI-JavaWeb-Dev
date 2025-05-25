package com.wheat.service.impl;

import com.wheat.mapper.EmpMapper;
import com.wheat.pojo.JobOption;
import com.wheat.pojo.Result;
import com.wheat.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 统计员工职位人数
     */
    @Override
    public JobOption getEmpJobData() {
        //1.调用mapper接口,获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData(); // map: pos=教研主管 num=1

        //2.组装结构,并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList,dataList);
    }

    /**
     * 统计员工性别人数
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        
        
        return empMapper.countEmpGenderData();
    }
}
