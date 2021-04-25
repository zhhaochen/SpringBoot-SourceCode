#### Spring Aware

Spring的依赖注入的最大亮点就是所有的Bean对Spring容器的存在是没有意识的，可以将容器替换成别的容器，Bean之间的耦合度很低。

实际项目中不可避免地用到Spring容器本身的功能资源，Bean必须要意识到Spring容器的存在，才能调动Spring所能提供的资源，这就是所谓的Spring Aware。

Spring Aware本来是Spring设计用来框架内部使用的，若使用了Spring Aware，你的Bean会和Spring框架耦合。

Spring Aware的目的是为了让Bean获得Spring容器的服务。