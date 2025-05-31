package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.mapper.StudentMapper;
import com.wheat.pojo.PageResult;
import com.wheat.pojo.Student;
import com.wheat.pojo.StudentQueryParam;
import com.wheat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    

    // =================== 学生列表分页查询 =====================
    @Override
    public PageResult<Student> page(StudentQueryParam sqp) {
        //1.设置PageHelper分页参数
        PageHelper.startPage(sqp.getPage(), sqp.getPageSize());
        
        //2.执行查询
        List<Student> studentList = studentMapper.pageList(sqp);
        
        //3.解析查询结果,并封装
        Page<Student> s = (Page<Student>) studentList;
        return new PageResult<>(s.getTotal(), s.getResult());
    }


    // =================== 添加学生 =====================
    @Override
    public void addStudent(Student student) {
        //1.设置学生的基础属性
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        
        // 2.执行添加
         studentMapper.addStudent(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getInfo(id);
    }
}