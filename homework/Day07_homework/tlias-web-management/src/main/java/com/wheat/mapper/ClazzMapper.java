package com.wheat.mapper;

import com.wheat.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * public class Clazz {
 * private Integer id; //ID
 * private String name; //班级名称
 * private String room; //班级教室
 * private LocalDate beginDate; //开课时间
 * private LocalDate endDate; //结课时间
 * private Integer masterId; //班主任
 * private Integer subject; //学科
 * private LocalDateTime createTime; //创建时间
 * private LocalDateTime updateTime; //修改时间
 * }
 */

@Mapper
public interface ClazzMapper {
    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "VALUES (#{name}, #{room}, #{beginDate}, #{endDate} , #{masterId} ,#{subject} , #{createTime}, #{updateTime})")
    void addClazz(Clazz clazz);

    // 查询所有班级
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> findAll();
}
