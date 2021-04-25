package ch1.ch1_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 从配置类拿到 IOC 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        // 获取声明配置的类的 bean
        UseFunctionService service = context.getBean(UseFunctionService.class);
        System.out.println(service.sayHello("di"));
        context.close();
    }
}
