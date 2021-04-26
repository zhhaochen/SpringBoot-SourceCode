package ch3.ch5_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //接口、类、枚举
@Retention(RetentionPolicy.RUNTIME) // 运行时时间
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {}; // 覆盖value参数
}
