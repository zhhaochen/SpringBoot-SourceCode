package ch3.ch2_taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("ch3.ch2_taskexecutor")
@EnableAsync // 注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {
    @Override
    // 实现 AsyncConfigurer 接口，返回一个基于线程池（底层是ThreadPoolExecutor）的
    public Executor getAsyncExecutor() {
        // 注意这里不是 ThreadPoolExecutor
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
