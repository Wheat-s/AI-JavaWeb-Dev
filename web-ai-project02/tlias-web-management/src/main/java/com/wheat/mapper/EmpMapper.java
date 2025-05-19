package com.wheat.mapper;

import com.wheat.pojo.Emp;
import com.wheat.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
     
    // 
    // @Select("select e.*, d.name deptName from emp e left join dept d  on e.dept_id = d.id " +
    //             "where e.name like '%阮%' and e.gender = 1 and e.entry_date between '2010-01-01' and '2020-01-01'" +
    //             "order by e.update_time desc")

    /**
     * 条件查询员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);
 
}
