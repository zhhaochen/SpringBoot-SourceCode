package ch1.ch2_config;

import org.springframework.stereotype.Service;

//@Service 此处不用声明
public class FunctionService {
    public String sayHello(String word){
        return "hello " + word + "!";
    }
}
