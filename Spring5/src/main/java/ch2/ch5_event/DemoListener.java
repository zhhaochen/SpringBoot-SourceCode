package ch2.ch5_event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 事件监听器，实现了接口，并指定监听的事件类型
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    // 对接受消息进行处理
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("bean-demoListener接口到了bean-demoPublisher发布的消息：" + msg);
    }
}
