package cn.dao;

import cn.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface gradeMapper {

    @Select("select *from grade_8001")
    public List<Grade> getlist();

    @Select("select * from grade_8001 where id=#{id}")
    public Grade get(@Param("id") Integer id);
}
