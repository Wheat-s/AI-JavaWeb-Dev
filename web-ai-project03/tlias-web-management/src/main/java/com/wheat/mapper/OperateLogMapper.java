package com.wheat.mapper;

import com.wheat.pojo.OperateLog;
import com.wheat.pojo.OperateLogQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    //查询日志数据
    List<OperateLog> pageList(OperateLogQueryParam logQueryParam);
}
