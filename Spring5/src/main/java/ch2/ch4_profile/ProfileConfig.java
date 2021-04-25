package ch2.ch4_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev") // 为 dev 时实例化
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod") // 为 prod 时实例化
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}
