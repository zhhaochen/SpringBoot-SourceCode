package ch1.ch1_di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 声明是一个配置类
@ComponentScan("ch1.ch1_di") // 配置扫描路径
public class DiConfig {
}
