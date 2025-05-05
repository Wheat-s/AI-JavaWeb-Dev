package com.wheat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用户信息单元测试类")
public class UserService2Test {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    /**
     * 测试获取性别 - null
     */
    @Test
    @DisplayName("获取性别 - null 值")
    public void testGetGender1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    /**
     * 测试获取性别 - ""
     */
    @Test
    @DisplayName("获取性别 - 空串")
    public void testGetGender2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("");
        });
    }

    /**
     * 测试获取性别 - 长度不足
     */
    @Test
    @DisplayName("获取性别 - 长度不足 ")
    public void testGetGender3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("110");
        });
    }

    /**
     * 测试获取性别 - 超出长度
     */
    @Test
    @DisplayName("获取性别 - 超出长度")
    public void testGetGender4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("11011011011011011011011101110110110");
        });
    }

    /**
     * 测试获取性别 - 正常男性身份证
     */
    @Test
    @DisplayName("获取性别 - 正常男性身份证")
    public void testGetGender5() {
        String gender = userService.getGender("610927199101010011");
        Assertions.assertEquals("男", gender);
    }

    /**
     * 测试获取性别 - 正常男性身份证
     */
    @Test
    @DisplayName("获取性别 - 正常女性身份证")
    public void testGetGender6() {
        String gender = userService.getGender("610927199101010021");
        Assertions.assertEquals("女", gender);
    }

    // ---------------测试获取年龄------------------

    /**
     * 测试获取年龄 - 正常身份证
     */
    @Test
    @DisplayName("获取年龄 - 正常身份证")
    public void testGetAge1() {
        Integer age = userService.getAge("610927199101010011");
        Assertions.assertEquals(34, age);
    }

    /**
     * 测试获取年龄 - null 值
     */
    @Test
    @DisplayName("获取年龄 - null 值")
    public void testGetAge2() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
           userService.getAge(null);
       });
    }

    /**
     * 测试获取年龄 - 超长
     */
    @Test
    @DisplayName("获取年龄 - 长度超长")
    public void testGetAge3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("6109271991010100111231");
        });
    }

    /**
     * 测试获取年龄 - 长度不足
     */
    @Test
    @DisplayName("获取年龄 - 长度不足")
    public void testGetAge4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("6109271991010100");
        });
    }

}
