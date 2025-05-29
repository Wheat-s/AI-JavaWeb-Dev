package com.wheat.mapper;

import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.EmpQueryParam;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
=======
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 42c9923 (完成了根据ID查询班级/修改班级/删除班级/的接口.今天的学习任务就到这里了.----在提交时,发现还有一个判断班级内是否有学生这个功能没有时间,经过ai 搞定了.)

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface  ClazzMapper {
    
    //-------------- 原始方式 分页方法 -----------------
    // 获取总记录数
    // @Select("select count(*) from clazz c left join emp e on c.master_id = e.id")
    // Long count();
    
    // 获取班级列表
    //public List<Clazz> getClazzList(Integer page, Integer pageSize);
    

    //-------------- PageHelper 分页方法 -----------------
    /**
     * 查询所有的班级和对应的班主任姓名
     * @return
     */
    // @Select("select c.*, e.name as masterName from clazz c left join emp e on c.master_id = e.id")
    //public List<Clazz> list();

    // =================== 条件分页查询 分页方法 =====================
    //List<Clazz> pageList(@Param("name") String name, @Param("begin") LocalDate begin, @Param("end")LocalDate end);

    
    // =============== 使用封装好的ClazzQueryParam对象 实现 分页方法 =====================
    List<Clazz> pageList(ClazzQueryParam clazzQueryParam);

<<<<<<< HEAD
    void addClazz(Clazz clazz);
=======
    // =================== 添加班级 =========================
    void addClazz(Clazz clazz);

    // =================== 根据ID查询班级 ======================
    Clazz getInfo(Integer id);

    // =================== 修改班级信息接口 =====================
    void updateById(Clazz clazz);

    // =================== 删除班级信息接口 =====================
    //查询是否有学生在该班级
    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countStudentByClazzId(Integer id);
    //删除班级
    @Delete("delete from clazz where id = #{id}")
    void deleteByClazzId(@Param("id")Integer id);
    
>>>>>>> 42c9923 (完成了根据ID查询班级/修改班级/删除班级/的接口.今天的学习任务就到这里了.----在提交时,发现还有一个判断班级内是否有学生这个功能没有时间,经过ai 搞定了.)
}