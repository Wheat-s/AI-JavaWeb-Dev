package org.wheat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户类，用于表示系统中的用户信息
 * 该类使用了Lombok注解来简化构造函数、getter和setter的编写
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户ID，唯一标识一个用户
     */
    private Integer id;

    /**
     * 用户名，用于登录系统
     */
    private String username;

    /**
     * 密码，用于登录系统
     */
    private String password;

    /**
     * 用户姓名，用于显示用户的真实姓名
     */
    private String name;

    /**
     * 年龄，表示用户的年龄
     */
    private Integer age;
}
