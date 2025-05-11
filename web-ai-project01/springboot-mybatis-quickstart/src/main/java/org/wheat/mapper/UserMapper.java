package org.wheat.mapper;

import org.apache.ibatis.annotations.*;
import org.wheat.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     */
    // @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据id删除用户
     */
    @Delete("delete from user where id = #{id}")
    // public void deleteById(Integer id);
    public Integer deleteById(Integer id);

    /**
     * 添加用户
     */
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);
    
    /**
     * 修改用户
     */
    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    /**
     * 根据用户名和密码查询用户
     * 注意: @Param的使用场景
     * 如果是基于springboot官方骨架创建的springboot项目, 该注解可以省略
     *
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    // public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    public User findByUsernameAndPassword(String username, String password);
}