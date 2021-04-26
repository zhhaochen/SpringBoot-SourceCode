package ch3.ch4_conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        // 注意这里，拿的是接口的service
        ListService bean = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") +
                "系统下的列表命令为：" +
                bean.showListCmd());
    }
}
