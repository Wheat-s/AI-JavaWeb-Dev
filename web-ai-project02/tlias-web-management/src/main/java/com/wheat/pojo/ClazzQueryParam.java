package com.wheat.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 封装班级查询参数
 * @author wheat
 */
@Data
public class ClazzQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    
    // 添加校验
    public void validate() {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            page = 10;
        }
        if (begin != null && end != null && begin.isAfter(end)) {
            throw new IllegalArgumentException("开始时间不能晚于结束时间.");
        }
    }
}
