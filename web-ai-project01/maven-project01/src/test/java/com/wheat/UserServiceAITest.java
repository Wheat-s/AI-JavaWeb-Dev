package com.wheat;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("用户服务单元测试类")
public class UserServiceAITest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    /**
     * 测试获取性别 - null 值
     */
    @Test
    @DisplayName("获取性别 - null 值")
    public void testGetGenderWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        }, "当身份证号为null时应抛出IllegalArgumentException");
    }

    /**
     * 测试获取性别 - 空字符串
     */
    @Test
    @DisplayName("获取性别 - 空字符串")
    public void testGetGenderWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("");
        }, "当身份证号为空字符串时应抛出IllegalArgumentException");
    }

    /**
     * 测试获取性别 - 长度不足的字符串
     */
    @Test
    @DisplayName("获取性别 - 长度不足")
    public void testGetGenderWithShortLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("11011011011011011");
        }, "当身份证号长度不足18位时应抛出IllegalArgumentException");
    }

    /**
     * 测试获取性别 - 长度过长的字符串
     */
    @Test
    @DisplayName("获取性别 - 长度过长")
    public void testGetGenderWithLongLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("11011011011011011011011101110110110");
        }, "当身份证号长度超过18位时应抛出IllegalArgumentException");
    }

    /**
     * 测试获取性别 - 正常男性身份证
     */
    @Test
    @DisplayName("获取性别 - 正常男性身份证")
    public void testGetGenderForMale() {
        String gender = userService.getGender("610927199101010011");
        assertEquals("男", gender, "第17位为奇数时应返回'男'");
    }

    /**
     * 测试获取性别 - 正常女性身份证
     */
    @Test
    @DisplayName("获取性别 - 正常女性身份证")
    public void testGetGenderForFemale() {
        String gender = userService.getGender("610927199101010021");
        assertEquals("女", gender, "第17位为偶数时应返回'女'");
    }
}
