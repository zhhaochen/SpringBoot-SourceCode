package ch3.ch5_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.outputResult();
        context.close();
    }
}
