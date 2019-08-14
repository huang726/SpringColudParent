package cn.dao;

import cn.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface gradeMapper {

    @Select("select *from grade_8002")
    public List<Grade> getlist();

    @Select("select *from grade_8002 where id=#{id}")
    public Grade get(int id);
}
