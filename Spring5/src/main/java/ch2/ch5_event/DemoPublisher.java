package ch2.ch5_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// 事件发布器
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext; // 注入 context 用来发布事件

    public void publish(String msg){
        // 使用 context的 publishEvent 方法来发布事件
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
