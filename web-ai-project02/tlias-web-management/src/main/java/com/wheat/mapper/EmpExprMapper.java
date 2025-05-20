package com.wheat.mapper;

import com.wheat.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工信息
     */
    void insertBatch(List<EmpExpr> exprList);
}
