#### Profile

Profile 为在不同环境下使用不同的配置提供了支持

- 通过设定`Environment` 的 `ActiveProfiles` 来设定当前的 `context`需要使用的配置环境。在开发中使用`@Profile`注解类或者方法，达到在不同情况下实例化不同的Bean。

- 通过设定 jvm 的 `spring.profiles.active` 参数来设置配置环境

- Web 项目设置在Servlet 的 `context parameter`中 