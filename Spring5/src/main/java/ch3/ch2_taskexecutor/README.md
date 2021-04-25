#### 多线程

Spring 通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用ThreadPoolTaskExecutor可以实现一个基于线程池的TaskExecutor。

实际开发中的任务一般是非阻碍的，即异步的，所以要在配置类中通过`@EnableAsync`开启对异步任务的支持，并通过在实际执行的Bean的方法中使用`@Async`注解来声明其是一个异步任务。