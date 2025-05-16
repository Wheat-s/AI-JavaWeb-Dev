import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * - 定义测试类 UserService3Test ：
 * 基于 @Test 注解，完成下面5个方法的单元测试程序编写【基于断言方式】 。
 */
public class EmpServiceTest3 {
    EmpService  empService = new EmpService();
    
    @Test
    public void isBeijing() {
        assertTrue(empService.isBeijing("110101199001011234"),"测试是否为北京籍贯");
        assertFalse(empService.isBeijing("390101199001011234"),"测试是否为北京籍贯");
    }



    @Test
    public void getAge() {
        Integer age = empService.getAge("110101199001011234");
        // assertEquals(age,18,"测试获取年龄");
        assertTrue(age>=18 && age <= 100,"测试获取年龄");
        System.out.println("年龄: " + age);
        
    }

    @Test
    public void getGender() {
        String gender = empService.getGender("110101199001011234");
        // assertEquals(gender,"男","测试获取性别");
        assertTrue(gender.equals("男") || gender.equals("女"),"测试获取性别");
        System.out.println("性别: " + gender);
    }
    

    @Test
    public void getYear() {
        String year = empService.getYear("110101199001011234");
        assertEquals(year,"1990","测试获取年份");
        System.out.println(year + "年");
    }

    @Test
    public void getMonth() {
        String month = empService.getMonth("110101199001011234");
        assertEquals(month,"01","测试获取月份");
        System.out.println(month + "月");
    }
}