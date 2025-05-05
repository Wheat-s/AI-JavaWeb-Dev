package com.wheat;

import com.wheat.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 测试类
 */
@DisplayName("用户信息单元测试类")
public class UserServiceTest {

    // @BeforeAll // 在所有的单元测试方法运行之前执行，只执行一次
    // public static void beforeAll() {
    //     System.out.println("beforeAll");
    // }
    //
    // @AfterAll  // 在所有的单元测试方法运行之后执行，只执行一次
    // public static void afterAll() {
    //     System.out.println("afterAll");
    // }
    //
    // @BeforeEach  //  在每一个测试方法运行之前，都会运行一次
    // public void beforeEach() {
    //     System.out.println("beforeEach");
    // }
    //
    // @AfterEach // 在每一个单元测试方法运行之后，都会运行一次
    // public void afterEach() {
    //     System.out.println("afterEach");
    // }

    // 测试获取年龄的方法
    @Test
    public void testGetAge() {
        // 创建UserService实例
        UserService userService = new UserService();
        // 调用getAge方法，传入身份证号码字符串，获取年龄
        Integer age = userService.getAge("610927199101010001");
        // 打印获取的年龄
        System.out.println(age);
    }

    // 测试获取性别的功能
    @Test
    public void testGetGender() {
        // 创建UserService的实例
        UserService userService = new UserService();
        // 调用getGender方法，传入身份证号码作为参数，获取性别信息
        String gender = userService.getGender("610927199101010031");
        // 输出性别信息
        System.out.println(gender);
    }

    /**
     * 断言
     */
    @Test
    public void testGenderWithAssert() {
        // 创建UserService的实例
        UserService userService = new UserService();
        // 调用getGender方法，传入身份证号码作为参数，获取性别信息
        String gender = userService.getGender("610927199101010031");
        // 断言
        // Assertions.assertEquals(gender, "男");
        Assertions.assertEquals("男", gender, "性别获取错误有问题。");
    }


    // 测试用例，用于验证当输入为null时，getGender方法会抛出NullPointerException异常
    @Test
    public void testGenderWithAssert2() {
        // 创建UserService的实例
        UserService userService = new UserService();
        // 断言 测试异常数据
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    /**
     * 参数化测试
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"610927199101010011", "610927199101010031", "610927199101010032"})
    public void testGetGender2(String idCard) {
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        // 断言
        Assertions.assertEquals("男", gender);
    }
}

