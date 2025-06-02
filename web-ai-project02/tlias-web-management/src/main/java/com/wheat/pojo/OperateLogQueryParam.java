package com.wheat.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OperateLogQueryParam {
    private Integer page = 1;       // 当前页码
    private Integer pageSize = 10;  // 每页显示条数
    private Integer operateEmpId; //操作人ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operateTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
    private Long costTime; //操作耗时
    private String operateEmpName; //操作人名称
}
