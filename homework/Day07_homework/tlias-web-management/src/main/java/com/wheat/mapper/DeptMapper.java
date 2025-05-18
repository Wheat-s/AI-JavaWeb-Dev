package com.wheat.mapper;

import com.wheat.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有的部门数据
     */
    // 方式一: 手动映射
    // @Results({
    //         @Result(column = "create_time",property = "createTime"),
    //         @Result(column = "update_time",property = "updateTime")
    // })

    // 方式二:起别名
    // @Select("select id, name, create_time createTime, update_time updateTime from dept order by create_time desc")

    // 方式三:开启mybatis的驼峰命名规则.去xml里配置.(推荐)
    //     map-underscore-to-camel-case: true
    @Select("select id, name, create_time, update_time from dept order by create_time desc")
    List<Dept> findAll();


    /**
     * 根据ID删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Update("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime} )")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
