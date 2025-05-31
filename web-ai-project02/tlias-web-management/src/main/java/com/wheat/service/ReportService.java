package com.wheat.service;

import com.wheat.pojo.ClazzOption;
import com.wheat.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别人数
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计学生人数
     */
    ClazzOption getStudentCountData();

    /**
     * 学生学历统计
     */
    List<Map<String, Object>> getStudentDegreeData();
}
