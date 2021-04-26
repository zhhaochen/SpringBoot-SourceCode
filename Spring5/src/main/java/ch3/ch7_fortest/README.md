## 测试

集成测试提供了一种无需部署或运行程序来完成验证系统各个部分是否能正常协同工作的能力。

Spring 通过 Spring TestContext Framework对集成测试提供顶级支持，不依赖于特定的测试框架，既可用用 Junit，也可以用 TestNG。

Spring 提供了一个 SpringJUnit4ClassRunner 类，提供了 Spring TestContext Framework 的功能。通过 @ContextConfiguration 来配置 Application Context，通过 @ActiveProfiles确定活动的 profile
