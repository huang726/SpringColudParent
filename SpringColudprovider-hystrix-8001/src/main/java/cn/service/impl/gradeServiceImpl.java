package cn.service.impl;

import cn.dao.gradeMapper;
import cn.entity.Grade;
import cn.service.gradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class gradeServiceImpl implements gradeService {
    @Resource
    gradeMapper gradeMapper;

    @Override
    public Grade get(Integer id) {
        return gradeMapper.get(id);
    }

    @Override
    public List<Grade> getlist() {
        return gradeMapper.getlist();
    }
}
