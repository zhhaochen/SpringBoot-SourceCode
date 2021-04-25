package ch2.ch2_el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("ch2.ch2_el")
@PropertySource("classpath:ch2/ch2_el/test.properties") // 注入配置文件，注意路径，这里放到了resource文件夹
public class ElConfig {

    // 注入普通字符串
    @Value("I love you")
    private String normal;

    // 注入操作系统属性
    @Value("#{ systemProperties['os.name'] }")
    private String osName;

    // 注入表达式结果
    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    // 注入其他 bean 的属性
    @Value("#{ demoService.another }")
    private String fromAnother;

    // 注入文件资源
    @Value("classpath:ch2/ch2_el/test.txt")
    private Resource testFile;

    // 注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    // 从 @PropertySource 得到配置，从这里注入
    @Value("${book.name}")
    private String bookName;

    // 注入 Properties 可以从 environment 中获得
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

