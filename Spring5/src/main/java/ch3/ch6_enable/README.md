## @Enable*注解的工作原理

- @EnableAspectJAutoProxy 开启对 AspectJ 自动代理的支持
- @EnableAsync 开启异步方法的支持
- @EnableScheduling 开启计划任务的支持
- @EnableWebMvc 开启 Web MVC 的支持
- @EnableConfigurationProperties 开启对 @ConfigurationProperties 注解配置Bena的支持
- @EnableJpaRepositories 开启对 Spring JPA Repository 的支持
- @EnableTransactionManagement 开启注解式事务的支持
- @EnableCaching 开启注解式的缓存支持

通过观察这些 @Enable* 注解的源码，所有的注解都有一个 @Import 注解，用来导入配置类的，意味着实际是导入了一些自动配置的 Bean。这些导入的配置方式主要分为以下三种类型。

#### 第一类：直接导入配置类
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SchedulingConfiguration.class})
@Documented
public @interface EnableScheduling {
}
```
这里直接导入配置类 SchedulingConfiguration，这个类注解了 @Configuration，且注册了一个 ScheduledAnnotationBeanPostProcessor 的 Bean
```java
@Configuration(
    proxyBeanMethods = false
)
@Role(2)
public class SchedulingConfiguration {
    public SchedulingConfiguration() {
    }

    @Bean(
        name = {"org.springframework.context.annotation.internalScheduledAnnotationProcessor"}
    )
    @Role(2)
    public ScheduledAnnotationBeanPostProcessor scheduledAnnotationProcessor() {
        return new ScheduledAnnotationBeanPostProcessor();
    }
}
```

#### 第二类：依据条件选择配置类

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AsyncConfigurationSelector.class})
public @interface EnableAsync {
    Class<? extends Annotation> annotation() default Annotation.class;

    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

    int order() default 2147483647;
}
```
AsyncConfigurationSelector 通过条件来选择需要导入的配置类， AsyncConfigurationSelector 的根接口为 ImportSelector，这个接口需要重写 selectImports 方法，在此方法内进行事先条件判断。

此例中，若 adviceMode 为 PROXY，则返回 ProxyAsyncConfiguration 配置类；若 adviceMode 为 ASPECTJ，则返回 AspectJAsyncConfiguration

```java
public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {
    private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME = "org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";

    public AsyncConfigurationSelector() {
    }

    @Nullable
    public String[] selectImports(AdviceMode adviceMode) {
        switch(adviceMode) {
        case PROXY:
            return new String[]{ProxyAsyncConfiguration.class.getName()};
        case ASPECTJ:
            return new String[]{"org.springframework.scheduling.aspectj.AspectJAsyncConfiguration"};
        default:
            return null;
        }
    }
}
```

#### 第三类：动态注册 Bean
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AspectJAutoProxyRegistrar.class})
public @interface EnableAspectJAutoProxy {
    boolean proxyTargetClass() default false;

    boolean exposeProxy() default false;
}
```
AspectJAutoProxyRegistrar 实现了 ImportBeanDefinitionRegistrar 接口，作用是运行时自动添加 Bean 到已有的配置类，通过重写方法

```java
public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {}
```
其中 AnnotationMetadata 参数用来获得当前配置类上的注解，BeanDefinitionRegistry 参数用来注册 Bean

```java
class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {
    AspectJAutoProxyRegistrar() {
    }

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
        AnnotationAttributes enableAspectJAutoProxy = AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
        if (enableAspectJAutoProxy != null) {
            if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
                AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
            }

            if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
                AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
            }
        }

    }
}

```