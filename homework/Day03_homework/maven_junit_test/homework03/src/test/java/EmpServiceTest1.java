import org.junit.jupiter.api.Test;

class EmpServiceTest1 {
    EmpService empService = new EmpService();
    @Test
    void isBeijing() {
        boolean beijing = empService.isBeijing("110101199001011234");
        System.out.println(beijing);
    }

    @Test
    void getAge() {
        Integer age = empService.getAge("110101199001011234");
        System.out.println(age);
    }

    @Test
    void getGender() {
        String gender = empService.getGender("110101199001011234");
        System.out.println(gender);
    }

    @Test
    void getYear() {
        String year = empService.getYear("110101199001011234");
        System.out.println(year);
    }

    @Test
    void getMonth() {
        String month = empService.getMonth("110101199001011234");
        System.out.println(month);
    }
}