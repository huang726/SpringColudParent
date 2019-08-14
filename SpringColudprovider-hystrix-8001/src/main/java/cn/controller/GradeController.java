package cn.controller;

import cn.entity.Grade;
import cn.service.gradeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value="/list/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Grade get(@PathVariable("id") Integer id) {
        Grade dept = gradeService.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    public Grade processHystrix_Get(@PathVariable("id") Integer id) {
        Grade grade=new Grade();
        grade.setId(id);
        grade.setName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
        return grade;
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
