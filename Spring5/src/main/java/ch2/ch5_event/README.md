#### 事件（Application Event）

Spring的时间为Bean与Bean之间的消息通信提供了支持，当一个Bean处理完一个任务之后，希望另外一个Bean知道并能做相应的处理，这时候就要让另外一个Bean监听当前Bean所发送的时间。

Spring的时间需要遵循以下流程：

1. 自定义事件，继承`ApplicationEvent`

2. 定义事件监听器，实现`ApplicationListener`

3. 使用容器发布事件