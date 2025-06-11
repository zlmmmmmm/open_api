# 接口星球

## 项目介绍

该项目是一个为开发者提供开放 API 发布与调用服务的平台，支持管理员接入并管理接口 资源，统计接口调用情况；普通用户可注册登录后开通权限、浏览接口详情、在线调试，并通过客户 端 SDK 快速集成调用接口。



## 技术选型

- **Spring Boot**
- **Mysql数据库**
- **MyBatis-Plus + MyBatisX**：简化数据库操作，支持代码自动生成
- **API签名认证**：用于接口调用的身份验证和安全控制
- **Spring Boot Starter** : 用于SDK开发
- **RPC远程调用**：支持不同项目或服务间的接口通信
- **Spring Cloud Gateway**：统一处理请求，实现路由、鉴权、限流等功能
- **Swagger + Knife4j**：生成接口文档，提升开发与对接效率
- **常用工具库**：包括 Hutool、Apache Commons、Gson 等，用于简化常规开发任务



## 项目架构

### 架构图

![image-20250611183515875](https://cdn.jsdelivr.net/gh/zlmmmmmm/PicGo/202506111836447.png)

### 文件架构

- **open_api_backend** : 后端管理系统
- **zlm_api** : 接口项目
- **zlm-api-client-sdk** : 发送请求的sdk项目
- **zlmapi-common** : 抽取出的公共方法
- **zlmapi-gateway** : 网关系统

## 

## 使用教程

todo....
