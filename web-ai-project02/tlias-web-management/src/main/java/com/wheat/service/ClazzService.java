package com.wheat.service;

import com.wheat.exception.BusinessException;
import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.PageResult;

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
    // =================== 添加班级 ======================
    void addClazz(Clazz clazz);
    
    // =================== 根据ID查询班级 ======================
    Clazz getInfo(Integer id);
    
    // =================== 修改班级信息接口 =====================
    void update(Clazz clazz);
    
    // =================== 删除班级信息接口 =====================
    void deleteByClazzId(Integer id) throws BusinessException;

    // =================== 查询所有班级 =====================
    List<Clazz> getClazzList();
}
