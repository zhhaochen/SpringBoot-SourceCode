package ch1.ch2_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 从配置类拿到 IOC 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // 获取声明配置的类的 bean，如果配置了两个，则不能通过这种方式拿取
//        UseFunctionService service = context.getBean(UseFunctionService.class);
        UseFunctionService service = (UseFunctionService) context.getBean("useFunctionService2");
        System.out.println(service.sayHello("java config"));
        context.close();
    }
}
