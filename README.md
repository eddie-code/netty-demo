[TOC]

# 高性能网络通信基石-Netty入门与提高

## 目录

- TCP通信与Netty基本介绍
- Netty 急速入门 + 案例
- Netty 技术选型应用于核心分析
- Netty TCP拆包粘包问题的处理
- Netty 序列化实战 Marshalling
- Netty 序列化实战 Protobuf
- Netty 自定义协议栈实战
- Netty HTTP协议栈
- Netty HTTP协议栈 关于RRxNetty Http应用
- Netty 项目实战 - 数据可靠性通信场景分析与架构设计
- Netty 项目最佳实践 - Server实现落地
- Netty 项目最佳实践 - Client实现落地
- Netty 项目最佳实践 - Netty负载均衡, 高可用架构
- Netty 项目最佳实践 - 性能调优实践-异步化数据处理
- Netty 项目最佳实践 - 性能调优实践-Linux性能调优

## 1-4 【难点分析】有状态应用如何实现弹性伸缩和失效重置

### 1.4.1 有状态应用如何弹性伸缩？

- 将有状态应用进行区分：共享磁盘模式和Share Nothing模式
- 共享磁盘模式 -> 无状态应用
- share Nothing模式 -> 采用合适的集群管理方式和CAP目标

### 1.4.2 向无状态应用转移

- 结构化数据 -> 共享数据库
- 非结构化数据 -> 共享缓存、对象存储、搜索引擎等
- 减少文件系统以来 (如CDN直接对接对象存储等)

### 1.4.3 Share Nothing架构

- CAP -优化可用性和分区性, 弱化一致性
- 集群管理 - 优化选举、仲栽、阶段提交、副本、分片管理
- 资源预配置



## 1-5 TCP拆包黏包问题讲解_基础概念介绍

- Netty TCP拆包粘包问题的处理
  - TCP底层的粘包 / 拆包机制
  - 分析TCP粘包、拆包问题的产生原因：
    - 应用程序write写入的字节大小大于套接口发送缓冲区的大小
	- 进行MSS大小的TCP分段、以太网帧的payload大于MTU进行IP分片等
- 粘包拆包问题的解决方案, 根据业界主流协议, 的有三种方案：
  - 消息定长, 例如每个报文的大小固定为200个字节, 如果不够, 空位补空格; 
  - 在包尾部增加特殊字符进行分割, 例如加回车等;
  - 消息分为消息头和消息体, 在消息头中包含表示消息总长度的字段, 然后进行业务处理;

## 2-1 Netty编解码技术介绍

- Netty 编解码技术, 主流序列化框架
- JBoss的Marshalling、MessagePack框架
- Google的Protobuf, 以及基于Protobuf的Kyro
- 自定义协议栈

## 2-2 Netty编解码技术之Marshalling（上）

- MarshallingCodeCFactory
- RequestData
- ResponseData
- Server
- ServerHandler








