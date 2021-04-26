## 依赖注入

#### 声明 Bean 的注解

- @Component 组件，没有明确的角色
- @Service 在业务逻辑层（service 层）使用
- @Repository 在数据访问层（dao 层）使用
- @Controller 在展示层（MVC - Spring MVC）使用

#### 注入 Bean 的注解

- @Autowired ：Spring 提供的注解
- @Inject：JSR-330 提供的注解
- @Resource：JSR-250 提供的注解

@Autowired、@Inject、@Resource 可注解在 set 方法上或者属性上