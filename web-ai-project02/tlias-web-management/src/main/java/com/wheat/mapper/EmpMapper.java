package com.wheat.mapper;

import com.wheat.pojo.Emp;
import com.wheat.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 新增员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // 插入数据后，返回主键值 用于绑定empID 插入的工作经历
    @Insert("insert into emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " VALUES(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工的基本信息
     */
    void deleteByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据ID查询员工信息及工作经历信息
     // * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工信息
     */
    void updateById(Emp emp);


    /**
     * 统计员工职位人数
     */
    // @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别人数
     */
    //@MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 查询所有员工信息
     */
    @Select("select e.*, d.name deptName from emp e left join dept d  on e.dept_id = d.id where e.job = 1")
    List<Emp> getList();

    /**
     * 根据用户名和密码查询员工信息
     */
    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
