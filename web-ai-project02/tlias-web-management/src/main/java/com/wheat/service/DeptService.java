package com.wheat.service;

import com.wheat.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门数据
     */
    List<Dept> findAll();
    
}
