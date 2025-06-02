package com.wheat.mapper;

import com.wheat.pojo.Student;
import com.wheat.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // =================== 学生列表分页查询 =====================
    List<Student> pageList(StudentQueryParam sqp);

    // =================== 添加学生 =====================
    void addStudent(Student student);

    // =================== 根据ID查询学生信息 =====================
    @Select("select student.*, clazz.id  from student left join clazz on student.clazz_id = clazz.id where student.id = #{id}")
    Student getInfo(Integer id);

    // =================== 根据ID查询学生信息 =====================
    void updateStudent(Student student);

    // =================== 删除学生信息接口 =====================
    void deleteStudentList(@Param("ids") List<Integer> ids);

    // =================== 违纪处理接口 ========================
    void updateViolation(@Param("id") Integer id, @Param("score") Integer score);

    // =================== 统计学生学历 ========================
    List<Map<String, Object>> getStudentDegreeData();
}   