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

    // =================== 根据ID查询学生信息 =====================
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getInfo(id);
    }

    // =================== 修改学生信息接口 =====================
    @Override
    public void updateStudent(Student student) {
        //1.修改基础属性
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    // =================== 删除学生信息接口 =====================
    @Override
    public void deleteStudentList(List<Integer> ids) {
        studentMapper.deleteStudentList(ids);
    }

    // =================== 违纪处理接口 ========================
    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}