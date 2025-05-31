package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.exception.BusinessException;
import com.wheat.mapper.ClazzMapper;
import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.EmpQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
   /* @Override
    public PageResult<Clazz> page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.pageList(name, begin, end);

        //3. 解析查询结果
        Page<Clazz> p = (Page<Clazz>) clazzList;

        //4.封装结果
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }*/


    // =============== 使用封装好的ClazzQueryParam对象 实现 分页方法 =====================

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //1.设置PageHelper分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        
        //2.执行查询
        List<Clazz> clazzList = clazzMapper.pageList(clazzQueryParam);
        
        //3.解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;

        //4.封装结果
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }
    // =================== 添加班级 =========================
    @Override
    public void addClazz(Clazz clazz) {
        //1.设置默认值
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    // =================== 根据ID查询班级 ======================
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getInfo(id);
    }


    // =================== 修改班级信息接口 =====================
    @Override
    public void update(Clazz clazz) {
        //1.根据id 修改班级的基本信息. 修改时间 updateTime
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    // =================== 删除班级信息接口 =====================
    @Override
    public void deleteByClazzId(Integer id) throws BusinessException {
        //1.判断该班级下面是否有学生
        Integer count = clazzMapper.countStudentByClazzId(id);
        if (count > 0) {
            throw new BusinessException("该班级下有学生，不能删除");
        }
        //2.如果没有学生 就执行 删除操作
        clazzMapper.deleteByClazzId(id);
    }
}
