package com.itheima.dao;

import cn.hutool.core.io.IoUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface DeptDao {
    public List<String> findAll();
}
