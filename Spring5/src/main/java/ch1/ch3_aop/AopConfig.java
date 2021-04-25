package ch1.ch3_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // 开启对AspectJ的支持
@ComponentScan("ch1.ch3_aop")
public class AopConfig {
}
