package ch1.ch2_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean // 注解在方法上，声明当前方法的返回值是一个 bean，bean的名称是方法名
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService service = new UseFunctionService();
        // set的时候可以直接调用方法
        service.setFunctionService(functionService(), 1);
        return service;
    }

    @Bean
//    另一种注入方式，可以直接把 functionService 作为参数传入，注意此时就不能用UseFunctionService.class获取，需要通过方法名
    public UseFunctionService useFunctionService2(FunctionService functionService){
        UseFunctionService service = new UseFunctionService();
        // set的时候可以直接调用方法
        service.setFunctionService(functionService, 2);
        return service;
    }
}
