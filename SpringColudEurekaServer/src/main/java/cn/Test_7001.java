package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启动服务端
public class Test_7001 {
    public static void main(String[] args) {
        SpringApplication.run(Test_7001.class,args);
    }
}
