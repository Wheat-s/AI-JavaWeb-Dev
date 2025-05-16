package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.DeptDao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<String>());
        return lines;
    }
}
