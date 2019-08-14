package cn.service;

import cn.entity.Grade;

import java.util.List;

public interface gradeService {
    public Grade get(int id);
    public List<Grade> getlist();
}
