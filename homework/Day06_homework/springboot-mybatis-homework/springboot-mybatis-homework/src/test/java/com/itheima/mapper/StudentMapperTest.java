package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void findAll() {
        studentMapper.findAll().forEach(System.out::println);
    }

    @Test
    void insert() {
        Student stu = new Student();
        stu.setName("张三123123");
        stu.setNo("1001");
        stu.setGender(1);
        stu.setPhone("13800000000");
        stu.setIdCard("110101199001011234");
        stu.setDegree(4);
        stu.setGraduationDate(LocalDate.now());
        stu.setCreateTime(LocalDateTime.now());
        stu.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(stu);

    }

    @Test
    void update() {
        Student stu = new Student();
        stu.setId(1);
        stu.setNo("1123123");
        stu.setPhone("13800000001");
        stu.setIdCard("110101199001011235");
        stu.setUpdateTime(LocalDateTime.now());
        studentMapper.update(stu);
        System.out.println(stu);
    }

    @Test
    void findById() {
        System.out.println("=================================");
        System.out.println(studentMapper.findById(2));
        System.out.println("=================================");
    }

    @Test
    void deleteById() {
        studentMapper.deleteById(11);
        
    }
}