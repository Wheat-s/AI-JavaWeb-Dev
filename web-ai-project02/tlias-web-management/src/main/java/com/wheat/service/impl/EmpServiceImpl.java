package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.mapper.EmpExprMapper;
import com.wheat.mapper.EmpMapper;
import com.wheat.pojo.*;
import com.wheat.service.EmpLogService;
import com.wheat.service.EmpService;
import com.wheat.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    /**
     * 原始分页查询
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {

        // 1.调用Mapper接口，查询总记录数
        Long total = empMapper.count();

        // 2.调用Mapper接口，查询结果列表
        // 获取起始索引的start
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        // 3. 封装PageResult对象返回
        return new PageResult<Emp>(total, rows);
    }*/

    /**
     * 原始分页查询
     *
     * @return
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {

        // 1.调用Mapper接口，查询总记录数
        Long total = empMapper.count();

        // 2.调用Mapper接口，查询结果列表
        // 获取起始索引的start
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        // 3. 封装PageResult对象返回
        return new PageResult<Emp>(total, rows);
    }*/
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


    @Transactional(rollbackFor = Exception.class) // 事务管理,默认出现RuntimeException时回滚
    @Override
    public void save(Emp emp) throws Exception {
        try {
            //1. 保存员工基本信息
            //1.1  设置基础属性
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            System.out.println("Inserted emp id: " + emp.getId()); // 应该是一个整数

            // int i = 1 / 0;

            //2. 保存员工工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                // 遍历集合,为empID赋值
                exprList.forEach(expr -> expr.setEmpId(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工:" + emp);
            empLogService.insertLog(empLog);
        }
    }


    /**
     * 根据ID批量删除员工的基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        //1.批量删除员工的基本信息
        empMapper.deleteByIds(ids);
        //2.批量删除员工的工作经历
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        //1.根据ID修改员工的基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //2.根据ID修改员工的工作经历
        //2.1 先根据员工ID删除原有的工作经历
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        //2.2 在添加这个员工新的工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            // 遍历集合,为empID赋值
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * 查询全部员工列表
     */
    @Override
    public List<Emp> getList() {

        return empMapper.getList();
    }

    /**
     * 员工登录
     */
    @Override
    public LoginInfo login(Emp emp) {
        //1.调用mapper借口,根据用户名和密码查询员工信息
        Emp e = empMapper.getByUsernameAndPassword(emp);

        //2.判断:判断是否存在这个员工,如果存在,组装登录成功信息
        if (e != null) {
            log.info("员工登录成功, 员工信息: {}", e);
            // 生成JWT领跑
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateToken(claims);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }
        //3.不存在,返回null
        return null;
    }


}
