package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 需求：
 * 1. 开发Mapper接口方法，查询全部学生信息，并编写对应的单元测试。 【基于注解方式配置SQL】 。
 * 2. 开发Mapper接口方法，往学生表中插入一条数据，并编写对应的单元测试。 【基于注解方式配置SQL】 。
 * 3. 开发Mapper接口方法，根据ID更新学生的学号、手机号、身份证号，并编写对应的单元测试。 【基于注解方式配置SQL】 。
 * 4. 开发Mapper接口方法，根据ID查询学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。
 * 5. 开发Mapper接口方法，根据ID删除学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】
 * public class Student {
 *     private Integer id; // ID, 主键
 *     private String name; // 姓名
 *     private String no; // 学号
 *     private Integer gender; // 性别, 1: 男, 2: 女
 *     private String phone; // 手机号
 *     private String idCard; // 身份证号
 *     private Integer degree; // 最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士
 *     private LocalDate graduationDate; // 毕业时间
 *     private LocalDateTime createTime; // 创建时间
 *     private LocalDateTime updateTime; // 修改时间
 * }
 */
@Mapper
public interface StudentMapper {
    
    /**
     * 1. 开发Mapper接口方法，查询全部学生信息，并编写对应的单元测试。 【基于注解方式配置SQL】 。
     */
    @Select("select * from student")
    public List<Student> findAll();
    
    /**
     * 2. 开发Mapper接口方法，往学生表中插入一条数据，并编写对应的单元测试。 【基于注解方式配置SQL】 。
     */
    @Insert("insert into student(name, no, gender, phone, id_card, degree, graduation_date, create_time, update_time) values(#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{degree}, #{graduationDate},#{createTime}, #{updateTime})")
    public void insert(Student student);
    
    /**
     * 3. 开发Mapper接口方法，根据ID更新学生的学号、手机号、身份证号，并编写对应的单元测试。 【基于注解方式配置SQL】 。
     */
    @Insert("update student set no = #{no}, phone = #{phone}, id_card = #{idCard}, update_time = #{updateTime} where id = #{id}")
    public void update(Student student);
    
    /**
     * 4. 开发Mapper接口方法，根据ID查询学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。
     */
    // @Select("select * from student where id = #{id}")
    public Student findById(Integer id);
    
    /**
     * 5. 开发Mapper接口方法，根据ID删除学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】
     */
    // @Delete("delete from student where id = #{id}")
    public void deleteById(Integer id);
}
