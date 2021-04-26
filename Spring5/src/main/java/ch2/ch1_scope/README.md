## Bean的Scope

Scope 描述的是 Spring 容器如何新建 Bean 的实例的。Spring 的 Scope 有以下几种，通过 @Scope 注解来实现。

（1）Singleton：一个Spring容器中只有一个Bean的实例，此为Spring的默认配置，全容器共享一个实例。

（2）Prototype：每次调用新建一个Bean的实例

（3）Request：Web 项目中，给每一个http request新建一个 Bean 实例

（4）Session：Web 项目中，给每一个http session新建一个 Bean 实例

（5）GlobalSession：这个只在portal应用中有用，给每一个global http session新建一个 Bean 实例