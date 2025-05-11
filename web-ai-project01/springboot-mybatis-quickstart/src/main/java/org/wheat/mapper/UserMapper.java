package org.wheat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wheat.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     */
    @Select("select * from user")
    public List<User> findAll();

}