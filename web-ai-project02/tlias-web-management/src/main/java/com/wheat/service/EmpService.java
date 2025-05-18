package com.wheat.service;

import com.wheat.pojo.Emp;
import com.wheat.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询
     * @param page      页码
     * @param pageSize  每页条数
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
