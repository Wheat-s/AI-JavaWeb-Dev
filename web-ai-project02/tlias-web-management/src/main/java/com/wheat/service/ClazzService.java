package com.wheat.service;

import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.EmpQueryParam;
import com.wheat.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    
    /**
     * 获取班级列表
     * 分页查询
     */
    // =================== 原始方式 分页方法 =====================
    //PageResult<Clazz> getClazzList(Integer page, Integer pageSize);

    // =================== 条件分页查询 分页方法 =====================
    //PageResult<Clazz> page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);

    // =================== 使用封装好的ClazzQueryParam对象 实现 分页方法 =====================
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 添加班级
     */
    void addClazz(Clazz clazz);
}
