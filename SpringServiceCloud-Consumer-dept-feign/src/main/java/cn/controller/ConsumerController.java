package cn.controller;

import cn.entity.Grade;
import cn.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerController {

    @Resource
    private DeptClientService service;

    @RequestMapping("/hh/list")
    public List<Grade> getlist() {
        return service.getlist();
    }

    @RequestMapping("/hh/list/{id}")
    public Grade get(@PathVariable("id") Integer id){return service.get(id);}

}
