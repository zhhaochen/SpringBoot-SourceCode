package ch2.ch4_profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 注意这里并没有将配置加载进来，同时下面涉及到 refresh
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 先将活动的 Profile 设置为 prod
        context.getEnvironment().setActiveProfiles("prod");
        // 后置注册 Bean 配置类，不然会报 Bean 未定义的错误
        context.register(ProfileConfig.class);
        // 刷新容器
        context.refresh();
        DemoBean bean = context.getBean(DemoBean.class);
        System.out.println(bean.getContent());
        context.close();
    }
}
