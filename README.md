# blog 大家一起做一个云笔记，学习 Spring Cloud 微服务技术

spring cloud 开始一个 blog 项目

## 项目管理通过 Maven 来进行项目管理
* 采用 Maven 的聚合和继承功能

## 整体采用 Spring Cloud 框架，包含以下技术栈：
* Eureka - 服务注册与发现
* Zuul - Api 网关
* Hystrix - 监控数据
* Spring Cloud Config - 配置管理中心

所有的服务调用都是通过 Restful 协议

## 项目结构
* eureka-server - 作为服务注册与发现服务器
* service-zuul - 作为 Api 网关，统一处理来自前端的所有服务调用请求
* \*-service - 具体的业务服务
