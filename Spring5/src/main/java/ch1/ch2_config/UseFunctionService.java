package ch1.ch2_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service 此处没有声明
public class UseFunctionService {

//    @Autowired 此处没有注入
    FunctionService functionService;

    // 这里添加了set方法
    public void setFunctionService(FunctionService functionService, int i) {
        this.functionService = functionService;
        System.out.println(i);
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
