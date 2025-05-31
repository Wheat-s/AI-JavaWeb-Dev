package com.wheat.controller;

import com.wheat.pojo.PageResult;
import com.wheat.pojo.Result;
import com.wheat.pojo.Student;
import com.wheat.pojo.StudentQueryParam;
import com.wheat.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // =================== 学生列表分页查询 =====================
    /*
        4.1 学员列表查询
        4.1.1 基本信息
        请求路径：/students
        请求方式：GET
        接口描述：该接口用于学员列表数据的条件分页查询
        
        4.1.2 请求参数
        参数格式：queryString
        参数说明：
            参数名称	    是否必须	    示例	    备注
            name	    否	        张三	    学员姓名
            degree	    否	        1	    学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
            clazzId	    否	        2	    班级ID
            page	    是	        1	    分页查询的页码，如果未指定，默认为1
            pageSize	是	        10	    分页查询的每页记录数，如果未指定，默认为10
        请求数据样例：/students?name=张三&degree=1&clazzId=2&page=1&pageSize=5
        
        4.1.3 响应数据
        参数格式：application/json
        参数说明：
            名称	                    类型	        是否必须	备注
            code	                number	    必须	    响应码, 1 成功 , 0 失败
            msg	                    string	    非必须	提示信息
            data	                object	    必须	    返回的数据
              |- total	            number	    必须	    总记录数
              |- rows	            object []	必须	    数据列表
                |- id	            number	    非必须	id
                |- name	            string	    非必须	姓名
                |- no	            string	    非必须	学号
                |- gender	        number	    非必须	性别(1: 男 , 2: 女)
                |- phone	        string	    非必须	手机号
                |- degree	        number	    非必须	学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
                |- idCard	        string	    非必须	身份证号
                |- isCollege	    number	    非必须	是否是院校学生 (1: 是, 0: 否)
                |- address	        string	    非必须	联系地址
                |- graduationDate	string	    非必须	毕业时间
                |- violationCount	number	    非必须	违纪次数    
                |- violationScore	number	    非必须	违纪扣分
                |- clazzId	        number	    非必须	班级ID
                |- clazzName	    string	    非必须	班级名称
                |- createTime	    string	    非必须	创建时间
                |- updateTime	    string	    非必须	更新时间
       响应数据样例：
        {
          "code": 1,
          "msg": "success",
          "data": {
            "total": 5,
            "rows": [
              {
                "id": 3,
                "name": "Lily",
                "no": "2023001003",
                "gender": 2,
                "phone": "13309230912",
                "degree": 4,
                "idCard": "110090110090110090",
                "isCollege": 0,
                "address": "回龙观东大街110号",
                "graduationDate": "2020-07-01",
                "violationCount": 2,
                "violationScore": 5,
                "clazzId": 1,
                "createTime": "2023-06-01T18:35:23",
                "updateTime": "2023-06-01T19:37:42",
                "clazzName": "黄埔班一期"
              },
              {
                "id": 4,
                "name": "Jerry",
                "no": "2023001004",
                "gender": 1,
                "phone": "15309232323",
                "degree": 4,
                "idCard": "110090110090110090",
                "isCollege": 0,
                "address": "回龙观东大街110号",
                "graduationDate": "2020-07-01",
                "violationCount": 1,
                "violationScore": 2,
                "clazzId": 1,
                "createTime": "2023-06-01T18:35:48",
                "updateTime": "2023-06-01T19:37:35",
                "clazzName": "黄埔班一期"
              }
            ]
          }
        }
     */
    @GetMapping
    public Result page(StudentQueryParam sqp){
        log.info("分页查询参数: {}", sqp);
        PageResult<Student> pageResult = studentService.page(sqp);
        return Result.success(pageResult);
    }


    // =================== 添加学生 =====================
    @PostMapping
    public Result addStudent(@RequestBody Student student){
        log.info("添加学生: {}", student);
        studentService.addStudent(student);
        return Result.success();
    }
    
    
    // =================== 根据ID查询学生信息 =====================
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询员工信息: {}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
}