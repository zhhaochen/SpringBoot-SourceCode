package ch1.ch3_aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD) // 作用域
@Retention(RetentionPolicy.RUNTIME) // 作用周期
@Documented // 表明这个注解应该被 javadoc工具记录
public @interface Action {
    String name();
}
