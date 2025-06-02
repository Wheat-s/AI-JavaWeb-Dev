package com.wheat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wheat.mapper.OperateLogMapper;
import com.wheat.pojo.OperateLog;
import com.wheat.pojo.OperateLogQueryParam;
import com.wheat.pojo.PageResult;
import com.wheat.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 日志分页查询
     */
    @Override
    public PageResult<OperateLog> page(OperateLogQueryParam logQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());

        //2. 执行查询
        List<OperateLog> logList = operateLogMapper.pageList(logQueryParam);

        //3. 解析查询结果,并封装
        Page<OperateLog> p = (Page<OperateLog>) logList;

        //4. 封装结果 返回结果
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
