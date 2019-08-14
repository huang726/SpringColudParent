package cn.service;

import cn.entity.Grade;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Grade> getlist() {
                return null;
            }

            @Override
            public Grade get(Integer id) {
                Grade grade = new Grade();
                grade.setId(id);
                grade.setName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                return grade;
            }
        };
    }
}
