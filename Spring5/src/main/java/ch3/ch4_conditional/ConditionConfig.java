package ch3.ch4_conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class) // 符合这个Condition条件的才会被实例化
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) // 符合这个Condition条件的才会被实例化
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
