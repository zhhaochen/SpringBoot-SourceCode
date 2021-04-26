## Bean 的初始化和销毁

实际开发时，经常会遇到在 Bean 只是用之前或者之后做些必要的操作，Spring对Bean的生命周期的操作提供了支持。主要有两种方式：

（1）Java 配置方式：使用@Bean 的 initMethod 和 destroyMethod

（2）注解方式：利用 JSR-250的@PostConstruct 和 @PreDestroy