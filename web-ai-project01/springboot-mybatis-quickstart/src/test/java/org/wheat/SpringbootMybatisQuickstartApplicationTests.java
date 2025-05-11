package org.wheat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wheat.mapper.UserMapper;
import org.wheat.pojo.User;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询所有用户
     */
    @Test
    public void findAll() {
        List<User> userList = userMapper.findAll();
        System.out.println("\n============================ 输出数据 =================================");
        userList.forEach(System.out::println);
        // userList.forEach(user -> System.out.println(user));
        System.out.println("========================================================================\n");
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(4);
        System.out.println("执行完毕,执行影响的记录数:" + i);

    }

    /**
     * 测试添加用户
     */
    @Test
    public void testInsert() {
        User user = new User(null, "admin", "123456", "管理员", 18);
        userMapper.insert(user);
    }

    /**
     * 修改用户信息
     */
    @Test
    public void testUpdate() {
        User user = new User(1,  "zhouyu", "123123", "周瑜", 28);
        userMapper.update(user);
    }
    
    /**
     * 测试查询用户
     */
    @Test
    public void textFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("zhouyu", "123123");
        System.out.println(user);
    }
}
