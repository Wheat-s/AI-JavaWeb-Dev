import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * - 定义测试类 UserService2Test ： 基于参数化测试注解 @ParameterizedTest ，输出测试结果 。
 *   - 要测试的身份证号为三个： 610110201909091231 ， 110110201509091109， 510310198812120931
 */
class EmpServiceTest2 {
    EmpService empService = new EmpService();
    // @Test
    @DisplayName("测试是否为北京籍贯")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    void isBeijing(String idcard) {
        boolean beijing = empService.isBeijing(idcard);
        System.out.println("是否是北京户口: " + beijing);
    }

    // @Test
    @DisplayName("测试获取年龄")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    void getAge(String idcard) {
        Integer age = empService.getAge(idcard);
        System.out.println(age);
    }

    // @Test
    @DisplayName("测试获取性别")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    void getGender(String idcard) {
        String gender = empService.getGender(idcard);
        System.out.println(gender);
    }

    // @Test
    @DisplayName("测试获取年份")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    void getYear(String idcard) {
        String year = empService.getYear(idcard);
        System.out.println(year);
    }

    // @Test
    @DisplayName("测试获取月份")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    void getMonth(String idcard) {
        String month = empService.getMonth(idcard);
        System.out.println(month);
    }
}