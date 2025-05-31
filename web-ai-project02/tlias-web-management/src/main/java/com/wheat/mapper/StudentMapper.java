package com.wheat.mapper;

import com.wheat.pojo.Student;
import com.wheat.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    // =================== 学生列表分页查询 =====================
    List<Student> pageList(StudentQueryParam sqp);

    // =================== 添加学生 =====================
    void addStudent(Student student);

    // =================== 根据ID查询学生信息 =====================
    @Select("select student.*, clazz.id  from student left join clazz on student.clazz_id = clazz.id where student.id = #{id}")
    Student getInfo(Integer id);
}   