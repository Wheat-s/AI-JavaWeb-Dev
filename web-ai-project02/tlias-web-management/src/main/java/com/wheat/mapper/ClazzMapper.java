package com.wheat.mapper;

import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    void addClazz(Clazz clazz);
}