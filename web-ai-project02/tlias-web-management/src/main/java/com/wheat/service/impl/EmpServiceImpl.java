package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.mapper.EmpExprMapper;
import com.wheat.mapper.EmpMapper;
import com.wheat.pojo.Emp;
import com.wheat.pojo.EmpExpr;
import com.wheat.pojo.EmpQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    

    /**
     * 原始分页查询
     *
     * @return
     */
    // @Override
    // public PageResult<Emp> page(Integer page, Integer pageSize) {
    //
    //     // 1.调用Mapper接口，查询总记录数
    //     Long total = empMapper.count();
    //    
    //     // 2.调用Mapper接口，查询结果列表
    //     // 获取起始索引的start
    //     Integer start = (page - 1) * pageSize;
    //     List<Emp> rows = empMapper.list(start, pageSize);
    //    
    //     // 3. 封装PageResult对象返回
    //     return new PageResult<Emp>(total, rows);
    // }
    
    /**
     * 原始分页查询
     *
     * @param page     页码
     * @param pageSize 每页条数
     * @return
     */
    // @Override
    // public PageResult<Emp> page(Integer page, Integer pageSize) {
    //
    //     // 1.调用Mapper接口，查询总记录数
    //     Long total = empMapper.count();
    //    
    //     // 2.调用Mapper接口，查询结果列表
    //     // 获取起始索引的start
    //     Integer start = (page - 1) * pageSize;
    //     List<Emp> rows = empMapper.list(start, pageSize);
    //    
    //     // 3. 封装PageResult对象返回
    //     return new PageResult<Emp>(total, rows);
    // }
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {

        //1. 设置分页参数（PageHelper） 
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        //3.解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }*/

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        //1. 设置分页参数（PageHelper） 
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        //3.解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Emp emp) {
        //1. 保存员工基本信息
        //1.1  设置基础属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println("Inserted emp id: " + emp.getId()); // 应该是一个整数
        
        //2. 保存员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            // 遍历集合,为empID赋值
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }
}
