package com.wheat.service;

import com.wheat.pojo.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClazzService {
    /**
     * 添加班级
     * @param clazz
     */
    void add(Clazz clazz);

    List<Clazz> findAll();
}
