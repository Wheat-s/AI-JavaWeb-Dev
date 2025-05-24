package com.wheat.service;

import com.wheat.pojo.Emp;
import com.wheat.pojo.EmpQueryParam;
import com.wheat.pojo.PageResult;

import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    void save(Emp emp) throws Exception;

    /**
     * 删除员工
     */
    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);


    /**
     * 分页查询
     * @param page      页码
     * @param pageSize  每页条数
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer  gender, LocalDate begin, LocalDate end);

    
}
