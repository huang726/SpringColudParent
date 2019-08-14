package cn.controller;

import cn.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
    //private static final String REST_URL_PREFIX = "http://localhost:8080";
    private static final String REST_URL_PREFIX = "http://SPRINGCOLUDPROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hh/list")
    public List<Grade> getlist() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/list", List.class);
    }

    @RequestMapping("/hh/list/{id}")
    public Grade get(@PathVariable("id") Integer id){

        return restTemplate.getForObject(REST_URL_PREFIX + "/list/"+id, Grade.class);
    }

    @RequestMapping("/hh/fa")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/fa", Object.class);
    }
}
