package com.wheat.mapper;

import com.wheat.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工信息
     */
    void insertBatch(@Param("exprList") List<EmpExpr> exprList);

    void deleteByEmpIds(@Param("empIds") List<Integer> empIds);
}
