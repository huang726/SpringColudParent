package cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.dao")
@SpringBootApplication
@EnableEurekaClient //将客户端添加进服务端
public class TestMain_8003 {
    public static void main(String[] args) {
        SpringApplication.run(TestMain_8003.class);
    }
}
