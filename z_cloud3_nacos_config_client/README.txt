A: 通过spring.cloud.nacos.config.shared-dataids定义的共享配置
B: 通过spring.cloud.nacos.config.ext-config[n]定义的加载配置
C: 通过内部规则（spring.cloud.nacos.config.prefix、spring.cloud.nacos.config.file-extension、spring.cloud.nacos.config.group这几个参数）拼接出来的配置
后面加载的配置会覆盖之前加载的配置，所以优先级关系是：A < B < C

默认情况下，只有默认加载的配置才会自动刷新，对于这些扩展的配置加载内容需要配置该设置时候才会实现自动刷新。

Nacos采用了集中式存储的方式来支持集群化部署，目前只要支持MySQL的存储。













