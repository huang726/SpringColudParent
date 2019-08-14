package cn.service;

import cn.entity.Grade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRINGCOLUDPROVIDER",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping("/list")
    public List<Grade> getlist();

    @RequestMapping("/list/{id}")
    public Grade get(@PathVariable("id") Integer id);
}
