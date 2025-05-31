package com.wheat.service.impl;

import com.wheat.exception.BusinessException;
import com.wheat.mapper.DeptMapper;
import com.wheat.pojo.Dept;
import com.wheat.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
    
    @Override
    public void deleteById(Integer id) {
        //1.判断该部门是否有员工
        Integer count = deptMapper.countEmpBy(id);
        // 如果没有则进行删除
        if(count > 0) {
            throw new BusinessException("该部门下有员工，不能删除");
        }
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //1. 补全基础属性 - createTime, updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        
        //2. 调用Mapper接口方法插入数据
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1. 补全基础属性 updateTime
        dept.setUpdateTime(LocalDateTime.now());
        
        //2. 调用Mapper方法更新部门
        deptMapper.update(dept);
    }
}
