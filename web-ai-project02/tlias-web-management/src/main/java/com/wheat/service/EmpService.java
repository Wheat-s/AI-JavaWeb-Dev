package com.wheat.service;

import com.wheat.pojo.Emp;
import com.wheat.pojo.EmpQueryParam;
import com.wheat.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    /**
     * 分页查询
     * @param page      页码
     * @param pageSize  每页条数
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer  gender, LocalDate begin, LocalDate end);

    
}
