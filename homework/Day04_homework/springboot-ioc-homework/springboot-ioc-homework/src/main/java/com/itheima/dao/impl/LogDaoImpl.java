package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.LogDao;
import com.itheima.pojo.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.lines;

public class LogDaoImpl implements LogDao {

 
    public List<String> findAll() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        ArrayList<String> logLines = IoUtil.readUtf8Lines(inputStream, new ArrayList<String>());

        return logLines;
    }
}
