package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.dao.impl.LogDaoImpl;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;

import java.util.List;
import java.util.stream.Collectors;

public class LogServiceImpl implements LogService {
    private LogDao logDao = new LogDaoImpl();
    @Override
    public List<Log> findAll() {
        List<String> lines = logDao.findAll();
        
        List<Log> logList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            return new Log(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
        }).toList();
        return logList;
    }
}
