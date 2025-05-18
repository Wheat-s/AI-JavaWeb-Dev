package com.wheat.service;

import com.wheat.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门数据
     */
    List<Dept> findAll();

    /**
     * 根据ID删除部门
     */
    void deleteById(Integer id);


    /**
     * 添加部门
     */
    void add(Dept dept);


    /**
     * 根据ID查询部门
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     */
    void update(Dept dept);
}
