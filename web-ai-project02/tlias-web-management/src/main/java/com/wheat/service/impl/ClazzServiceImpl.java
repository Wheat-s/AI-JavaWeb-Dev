package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.mapper.ClazzMapper;
import com.wheat.pojo.Clazz;
import com.wheat.pojo.PageResult;
import com.wheat.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    //-------------- 原始方式 分页方法 -----------------
    /*@Override
    public PageResult<Clazz> getClazzList(Integer page, Integer pageSize) {
        //1.获取数据总记录数
        Long total = clazzMapper.count();
        //2.获取结果列表
        // 设置开始索引的start
        Integer start = (page - 1) * pageSize;
        List<Clazz> rows = clazzMapper.getClazzList(start, pageSize);
        //3.封装结果
        return new PageResult<Clazz>(total, rows);
    }
*/
    //-------------- PageHelper 分页方法 -----------------
    /*@Override
    public PageResult<Clazz> getClazzList(Integer page, Integer pageSize) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list();
        
        //3. 解析查询结果
        Page<Clazz> p = (Page<Clazz>) clazzList;
        
        //4.封装结果
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }*/
    
    
    // =================== 条件分页查询 分页方法 =====================
    @Override
    public PageResult<Clazz> page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.pageList(name, begin, end);

        //3. 解析查询结果
        Page<Clazz> p = (Page<Clazz>) clazzList;

        //4.封装结果
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }
}
