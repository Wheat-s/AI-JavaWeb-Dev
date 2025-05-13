package com.wheat.controller;

import com.wheat.pojo.Dept;
import com.wheat.pojo.Result;
import com.wheat.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET) // method方法指定请求方式
    @GetMapping
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();

        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     */
    /**
     * 方式一: HttpServletRequest 获取请求参数
     */
    // @DeleteMapping("/depts")
    // public Result delete(HttpServletRequest request) {
    //     String idStr = request.getParameter("id");
    //     int id = Integer.parseInt(idStr);
    //     System.out.println("根据ID删除部门: " + id);
    //     return Result.success();
    // } 

    /**
     * 方式二: 通过Spring提供的 @RequestParam 注解, 将请求参数绑定给方法形参
     * 注意事项：一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错。（默认 required 为 true）
     */
    // @DeleteMapping("/depts")
    // public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
    //     System.out.println("根据ID删除部门: " + deptId);
    //     return Result.success();
    // }

    /**
     * 方式三: 如果请求参数名与形參变量名相同,直接定义方法形參即可接收. (省略 @RequestParam)
     * 前端传递的请求参数名与服务端方法形参名一致
     */
    @DeleteMapping
    public Result delete(Integer id) {
        System.out.println("根据ID删除部门: " + id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println("添加部门: " + dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门
     * 方式一
     */
    // @GetMapping("/depts/{id}")
    // public Result getInfo(@PathVariable("id") Integer deptId){
    //     System.out.println("根据ID查询部门: " + deptId);
    //     return Result.success();
    // }

    /**
     * 根据ID查询部门
     * 方式二 路径请求参数名和定义的参数名一致 可以省略@PathVariable
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        System.out.println("根据ID查询部门: " + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 根据ID修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门: " + dept);
        deptService.update(dept);
        return Result.success();
    }

}
