package com.wheat.controller;

import com.wheat.mapper.ClazzMapper;
import com.wheat.pojo.Clazz;
import com.wheat.pojo.ClazzQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.pojo.Result;
import com.wheat.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
     *
     * @return 总记录数(total), 当前页列表数据(rows)
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
        log.info("班级查询: page={}, pageSize={}, name={}, begin={}, end={}", clazzQueryParam.getPage(), clazzQueryParam.getPageSize(), clazzQueryParam.getName(), clazzQueryParam.getBegin(), clazzQueryParam.getEnd());
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
}
