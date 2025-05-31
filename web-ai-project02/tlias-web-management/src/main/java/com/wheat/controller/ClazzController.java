package com.wheat.controller;

import com.wheat.exception.BusinessException;
import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.pojo.Result;
import com.wheat.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    /**
     * 班级查询
     * 1. 输入班级名称进行搜索,支持模糊查询
     * 2. 选择结课时间的 开始时间 和 结束时间 进行查询,查询结果在开始时间和结束时间范围内(包含)的班级数据.
     * 3. 对查询结果进行分页展示,并根据最后修改时间进行倒序排序.
     * <p>
     * 注意：班级状态，显示为：未开班、已结课、在读中 这三种。
     * 如果：
     * - 当前时间 > 结课时间：状态未 已结课。
     * - 当前时间 < 开课时间：状态未 未开班。
     * - 否则，就是 在读中。
     *
     * <p>
     * 请求路径/clazzs
     * 请求方式 GET
     * 请求参数 name(可选),begin(可选),end(可选), page(必须), pageSize(必须)
     * 请求数据样例：/clazzs?name=java&begin=2023-01-01&end=2023-06-30&page=1&pageSize=5
     * 返回 总记录数(total), 当前页列表数据(rows)
     * 返回的列表数据示例:
     * {
     * "code": 1,
     * "msg": "success",
     * "data": {
     * "total": 6,
     * "rows": [
     * {
     * "id": 7,
     * "name": "黄埔四期",
     * "room": "209",
     * "beginDate": "2023-08-01",
     * "endDate": "2024-02-15",
     * "masterId": 7,
     * "createTime": "2023-06-01T17:51:21",
     * "updateTime": "2023-06-01T17:51:21",
     * "masterName": "纪晓芙",
     * "status": "已开班"
     * },
     * {
     * "id": 6,
     * "name": "JavaEE就业166期",
     * "room": "105",
     * "beginDate": "2023-07-20",
     * "endDate": "2024-02-20",
     * "masterId": 20,
     * "createTime": "2023-06-01T17:46:10",
     * "updateTime": "2023-06-01T17:46:10",
     * "masterName": "陈友谅",
     * "status": "未开班"
     * }
     * ]
     * }
     * }
     */

    @Autowired
    public ClazzService clazzService;


    // =================== 原始方式 分页方法 =====================
    /*@GetMapping
    public Result getClazzList(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("班级查询, page={}, pageSize{}", page,pageSize);
        PageResult<Clazz> pageRelust = clazzService.getClazzList(page,pageSize);
        
        return Result.success(pageRelust);
    }*/

    // =================== 条件分页查询 分页方法 =====================
    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("班级查询: page={}, pageSize={}, name={}, begin={}, end={}", page, pageSize, name, begin, end);
        PageResult<Clazz> pageResult = clazzService.page(page, pageSize, name, begin, end);
        return Result.success(pageResult);
    }*/

    // =================== 使用封装好的ClazzQueryParam对象 实现 分页方法 =====================
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("班级查询: clazzQueryParam={}", clazzQueryParam);
        clazzQueryParam.validate(); // 验证参数
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    // =================== 新增班级 =====================
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("新增班级: {}", clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    // =================== 根据ID查询班级 ======================
    /*
        3.4.1 基本信息
        请求路径：/clazzs/{id}
        请求方式：GET
        接口描述：该接口用于根据主键ID查询班级的信息
        
        3.4.2 请求参数
        参数格式：路径参数
        参数说明：参数名	类型	    是否必须	    备注
                  id	number	必须	        班级ID
        请求参数样例：/clazzs/8
        
        {
          "code": 1,
          "msg": "success",
          "data": {
            "id": 8,
            "name": "JavaEE就业166期",
            "room": "101",
            "beginDate": "2023-06-01",
            "endDate": "2024-01-25",
            "masterId": 7,
            "subject": 1,
            "createTime": "2023-06-04T17:37:45",
            "updateTime": "2023-06-04T17:37:45"
          }
        }
    */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }
    
    
    // =================== 修改班级信息接口 =====================
    /*
        3.5.1 基本信息
        请求路径：/clazzs
        请求方式：PUT
        接口描述：该接口用于修改班级的数据信息
        
        3.5.2 请求参数
        参数格式：application/json
        参数说明：
            名称	        类型	    是否必须	    备注
            id	        number	必须	        id
            name	    string	必须	        班级名称
            room	    string	必须	        班级教室
            beginDate	string	必须      	开课时间
            endDate	    string	必须	        结课时间
            masterId	number	必须	        班主任ID(员工ID)
            subject	    number	非必须	    学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6:嵌入式
        
        请求数据样例：
            {
              "id": 8,
              "name": "JavaEE就业166期",
              "room": "101",
              "beginDate": "2023-06-01",
              "endDate": "2024-01-25",
              "masterId": 7,
              "subject": 1
            }
            
        3.5.3 响应数据
        参数格式：application/json
        参数说明：
            {
                "code":1,
                "msg":"success",
                "data":null
            }
        
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    
    // =================== 删除班级信息接口 =====================
    /*
    3.2 删除班级
    3.2.1 基本信息
    请求路径：/clazzs/{id}
    请求方式：DELETE
    接口描述：该接口用于删除班级信息
    
    3.2.2 请求参数
    参数格式：路径参数
    参数说明：
        参数名	类型	    示例	    是否必须
        id	    number	1	    必须
    请求参数样例：/clazzs/5
    
    3.2.3 响应数据
    参数格式：application/json
    参数说明：
        参数名	类型	    是否必须	    备注
        code	number	必须	        响应码，1 代表成功，0 代表失败
        msg	    string	非必须	    提示信息
        data	object	非必须	    返回的数据
    响应数据样例：
        {
            "code":1,
            "msg":"success",
            "data":null
        }
        
        注意：在页面原型中，要求如果该班级下关联的有学生，是不允许删除的，
        并提示错误信息："对不起, 该班级下有学生, 不能直接删除"。
         (提示：可以通过自定义异常 + 全局异常处理器实现)
     */
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) throws BusinessException {
        log.info("删除班级: {}", id);
        clazzService.deleteByClazzId(id);
        return Result.success();
    }

    // =================== 查询所有班级 =====================
    @GetMapping("/list")
    public Result getClazzList() {
         log.info("查询所有班级");
         List<Clazz> clazzList = clazzService.getClazzList();
         return Result.success(clazzList);
    }
    
}
