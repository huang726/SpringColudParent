package cn.service;

import cn.entity.Grade;

import java.util.List;

public interface gradeService {

    public List<Grade> getlist();

    public Grade get(int id);
}
