package org.wheat.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wheat.pojo.User;
import org.wheat.service.UserService;

import java.util.List;

@RestController
public class UserController {

    // 方式一：属性注入
    // @Qualifier("userServiceImpl")
    // @Autowired
    // private UserService userService;
    @Resource(name = "userServiceImpl2")
    private UserService userService;

    // 方式二：构造器注入
    // private final UserService userService;
    // @Autowired
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    // 方式三：setter注入
    // private UserService userService;
    // @Autowired
    // public void setUserService(UserService userService) {
    //     this.userService = userService;
    // }


    /*
     // 1. 加载并读取user.text文件，获取用户信息
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        // 2. 解析用户信息，封装为User对象，添加到List集合中
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return new User(id, username, password, name, age, updateTime);
        }).toList();

        // 3. 返回数据
        return userList;
     */
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        // 1. 调用service 获取数据
        List<User> userList = userService.findAll();
        // 3. 返回数据
        return userList;
    }
}

