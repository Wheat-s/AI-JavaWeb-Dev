package com.wheat.service;

import com.wheat.pojo.OperateLog;
import com.wheat.pojo.OperateLogQueryParam;
import com.wheat.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(OperateLogQueryParam logQueryParam);
}
