package com.wheat.mapper;

import com.wheat.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    
    //-----------------------原始分页查询操作-------------------------
    /**
     * 获取员工总数
     */
    // @Select("select count(*) from emp e left join dept d  on e.dept_id = d.id")
    // public Long count();
    //
     /**
     * 分页查询员工数据
     */
    // @Select("select e.*, d.name deptName from emp e left join dept d  on e.dept_id = d.id " +
    //         "order by e.update_time desc limit #{start}, #{pageSize}")
    // public List<Emp> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
    // ----------------------------------------------------------------
     
     
    @Select("select e.*, d.name deptName from emp e left join dept d  on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> list();

}
