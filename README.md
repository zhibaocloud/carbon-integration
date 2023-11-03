# 智保云数据平台 SDK

[![Java CI with Maven](https://github.com/zhibaocloud/carbon-integration/actions/workflows/ci.yaml/badge.svg)](https://github.com/zhibaocloud/carbon-integration/actions/workflows/ci.yaml)
[![codecov](https://codecov.io/gh/zhibaocloud/carbon-integration/graph/badge.svg?token=M45BAZQJP7)](https://codecov.io/gh/zhibaocloud/carbon-integration)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.zhibaocloud/carbon-integration/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.zhibaocloud/carbon-integration)

## 数据平台项目是什么

该项目是 [智保云](https://zhibaocloud.com)
为满足 [保险中介机构信息化工作监管办法](http://www.gov.cn/zhengce/zhengceku/2021-01/13/content_5579627.htm)
中要求的 `通过技术手段实现与合作保险公司的系统互通、业务互联、数据对接` 而开发的 SaaS 化对接系统。
通过 SDK 的方式将业务逻辑、加解密方式进行封装，减少线上联调、以及减少文档工作。

项目代号: `Carbon`, 在一些 Java 内部实现类有 `Carbon` 前缀，用于区分其他通用类型。

## 如何启动

```bash
# 编译并安装到本地仓库
mvn clean install

# 启动后端 Demo 服务用于接收推送数据
# 当收到推送数据后会在控制台打印显示
mvn spring-boot:run -pl carbon-server-demo

# 启动 Client 项目向 Mock 服务发送数据
mvn spring-boot:run -pl carbon-client-demo
```

## 如何使用

### 数据推送方

使用 `carbon-client-sdk` 项目中的 `CarbonClient` 类进行数据推送。如推送方使用的是 spring-boot
构建，可以引入 `carbon-client-spring-boot-starter` 简化配置。

```xml
<dependencies>
   <dependency>
      <groupId>com.zhibaocloud</groupId>
      <artifactId>carbon-client-sdk</artifactId>
      <version>1.2.1</version>
   </dependency>
   <dependency>
      <groupId>com.zhibaocloud</groupId>
      <artifactId>carbon-client-spring-boot-starter</artifactId>
      <version>1.2.1</version>
   </dependency>
</dependencies>
```

示例项目参考 `carbon-client-demo`。是一个命令行程序，随机创建数据并进行推送

### 数据接收方

使用 `carbon-server-sdk` 项目中的 `MessageListener` 监听数据。如接收方使用的是 spring-boot
构建，可以引入 `carbon-server-spring-boot-starter` 简化配置。

```xml
<dependencies>
   <dependency>
      <groupId>com.zhibaocloud</groupId>
      <artifactId>carbon-server-sdk</artifactId>
      <version>1.2.1</version>
   </dependency>
   <dependency>
      <groupId>com.zhibaocloud</groupId>
      <artifactId>carbon-server-spring-boot-starter</artifactId>
      <version>1.2.1</version>
   </dependency>
</dependencies>
```

### 数据格式

数据交换格式定义在 `carbon-exchange` 项目中，该模块主要实现:

* 通过 Java POJO 的方式定义了两个系统之间的数据交换格式，并通过枚举方式定义取值范围
* 约定数据在网络中传输时的序列化、反序列化的方式 (当前使用 Jackson)
* 约定数据加解密的方式 (如: AES, SM4)

## FAQ

1. 我已经使用了https为什么还需要对报文进行加密
   > * 防止中间人攻击，或DNS劫持等情况
   > * 为了兼容老旧系统。如CA根证书未更新导致旧版JDK无法识别https中的证书。那么可以使用应用层加密与HTTP协议的方式来保证数据的安全性

2. 在交互过程中各种加密方法都是用来做什么的
   > * 对称加密: 用于加密报文中的数据，保证数据的机密性、不被外部窃听。看到的数据为密文
   > * 信息摘要:
       用于保证数据的完整性，防止数据被篡改或损坏。（一般对称加密是按block加密，丢掉几个block仍然可以解密只是内容会不正确。而信息摘要是对整个数据进行摘要，可以发现这种篡改）
   > * 非对称加密:
       用于保证数据的真实性、防止数据被伪造。（在非对称加密中：私钥加密只能公钥解密，公钥加密只能私钥解密。因此只要私钥未被泄漏，接收方如果能通过公钥解密数据就可以确认是私钥持有者发送的）

3. 支持的加密算法 (如使用国密，需要额外引入BC包)
   > * 对称加密: AES, SM4
   > * 信息摘要: SHA-256, SHA-512, SHA3-256, SHA3-512, MD5, SM3
   > * （暂未实现）非对称加密: RSA, SM2

4. 是否支持使用 fastjson 进行数据序列化
   > 暂无此计划

5. 是否支持 Jakarta EE
   > 当前项目中未引入任何 javax 包，理论上是可以在 Jakarta 环境中运行

6. 是否支持非 Java 语言，如 PHP
   > 暂无此计划。但是可以参考 `carbon-exchange` 项目中的数据格式定义，自行实现

