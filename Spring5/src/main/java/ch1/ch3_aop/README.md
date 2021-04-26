## AOP

AOP：面向切面变成，相对于 OOP 面向对象编程

Spring 的 AOP 的存在目的是为了解耦。AOP可以让一组类共享相同的行为。在OOP中只能通过继承类和实现接口，来使代码的耦合度增强，且类继承只能为单继承，阻碍更多行为添加到一组类上，AOP弥补了OOP的不足。

Spring 支持 AspectJ 的注解式切面编程

（1）使用@AspectJ声明是一个切面

（2）使用@After、@Before、@Around定义建言（advice），可直接将蓝结果则（切点）作为参数

（3）其中@After、@Before、@Around参数的拦截规则为切点（PointCut），为了使切点复用，可使用@PointCut专门定义拦截规则，然后再@After、@Before、@Around的参数调用。

（4）其中符合条件的每一个被拦截处为连接点（JointPoint）。

示例演示基于注解拦截和基于方法规则拦截两种方式。