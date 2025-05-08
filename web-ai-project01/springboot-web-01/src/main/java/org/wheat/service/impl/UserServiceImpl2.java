package org.wheat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wheat.dao.UserDao;
import org.wheat.pojo.User;
import org.wheat.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


// @Component
@Service
// @Primary
public class UserServiceImpl2 implements UserService {

    @Autowired // 表应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
    private UserDao userDao;

    @Override
    public List<User> findAll() {

        // 1. 调用Dao，获取用户信息
        List<String> lines = userDao.findAll();

        // 2. 解析用户信息，封装为User对象，添加到List集合中
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return new User(id + 200, username, password, name, age, updateTime);
        }).toList();

        return userList;
    }
}
