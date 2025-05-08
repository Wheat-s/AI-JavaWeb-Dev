package org.wheat.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Repository;
import org.wheat.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// @Component
@Repository // 表示当前类是一个组件，会被Spring容器扫描到并管理
public class UserDaoImpl implements UserDao {


    @Override
    public List<String> findAll() {
        // 1. 加载并读取user.text文件，获取用户信息
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
