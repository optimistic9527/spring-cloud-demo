[Eureka详细配置](http://blog.51cto.com/881206524/2117014)
- **Eureka instance**:
一个服务，如：订单系统，会部署多台服务器，而每台服务器上提供的服务就是instance; 负载配置。

- **Eureka service**:
指的是服务，提供一种特定功能的服务，如：订单系统，而同一个服务可以提供多个instance;
- **Eureka client**:
主要将自己的服务注册到服务中心。但它既可以是服务的提供者也可以是消费者。它与Eureka instance感觉差不多，但其实意义是不一样的，Eureka client是相较于Eureka server来说的。而Eureka instance更倾向于负载技术。
- **Eureka server**:
服务注册中心。并管理各服务的中心。