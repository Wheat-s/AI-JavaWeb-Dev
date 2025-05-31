package com.wheat.service;

import com.wheat.pojo.PageResult;
import com.wheat.pojo.Student;
import com.wheat.pojo.StudentQueryParam;

public interface StudentService {

    // =================== 学生列表分页查询 =====================
    PageResult<Student> page(StudentQueryParam sqp);


    // =================== 添加学生 =====================
    void addStudent(Student student);


    // =================== 根据ID查询学生信息 =====================
    Student getInfo(Integer id);
}