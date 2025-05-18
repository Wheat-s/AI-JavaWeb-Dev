package com.wheat.service.impl;

import com.wheat.mapper.ClazzMapper;
import com.wheat.pojo.Clazz;
import com.wheat.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    
    @Autowired
    ClazzMapper clazzMapper;
    @Override
    public void add(Clazz clazz) {
        // 补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        // 调用Mapper方法 插入数据
        clazzMapper.addClazz(clazz);
        
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
