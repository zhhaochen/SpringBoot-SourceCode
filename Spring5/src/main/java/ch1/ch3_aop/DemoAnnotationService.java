package ch1.ch3_aop;

import org.springframework.stereotype.Service;

@Service
// 基于注解的被拦截类
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add(){}
}
