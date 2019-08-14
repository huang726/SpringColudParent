package cn.controller;

import cn.entity.Grade;
import cn.service.gradeService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GradeController {
    @Resource
    gradeService gradeService;


    @RequestMapping("/list")
    public List<Grade> getlist() {
        return gradeService.getlist();
    }

    @RequestMapping("/list/{id}")
    public Grade get(@PathVariable("id") int id) {
        return gradeService.get(id);
    }

    //服务发现
    @Resource
    DiscoveryClient client;

    @RequestMapping("/fa")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println(list);
        List<ServiceInstance> instances = client.getInstances("SPRINGCOLUDPROVIDER");
        for (ServiceInstance instance : instances) {
            //微服务的ID                      主机名                        端口                         访问地址
            System.out.println(instance.getServiceId() + "---" + instance.getHost() + "---" + instance.getPort() + "---" + instance.getUri());
        }
        return client;
    }
}
