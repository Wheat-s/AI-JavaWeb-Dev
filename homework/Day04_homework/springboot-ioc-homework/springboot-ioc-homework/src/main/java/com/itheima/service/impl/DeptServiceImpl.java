package com.itheima.service.impl;

import com.itheima.dao.DeptDao;
import com.itheima.dao.impl.DeptDaoImpl;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    // 创建DeptDao对象 用来调用dao层代码
    private DeptDao deptDao = new DeptDaoImpl();
    @Override
    public List<Dept> findAll() {
        // 调用dao层代码
        List<String> lines = deptDao.findAll();
        // 把每一行数据封装成Dept对象 
        List<Dept> deptList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String name = parts[1];
            LocalDateTime updateTime = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new Dept(id, name, updateTime);
        }).toList();
        // 返回
        return deptList;
    }
}
