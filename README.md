# 智保云数据平台 SDK [![Java CI with Maven](https://github.com/zhibaocloud/carbon-integration/actions/workflows/ci.yaml/badge.svg)](https://github.com/zhibaocloud/carbon-integration/actions/workflows/ci.yaml) [![codecov](https://codecov.io/gh/zhibaocloud/carbon-integration/graph/badge.svg?token=M45BAZQJP7)](https://codecov.io/gh/zhibaocloud/carbon-integration)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.zhibaocloud/carbon-integration/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.zhibaocloud/carbon-integration)


## 数据平台项目是什么

该项目是 [智保云](https://zhibaocloud.com) 为满足 [保险中介机构信息化工作监管办法](http://www.gov.cn/zhengce/zhengceku/2021-01/13/content_5579627.htm)
中要求的 `通过技术手段实现与合作保险公司的系统互通、业务互联、数据对接` 而开发的 SaaS 化对接系统。 
通过 SDK 的方式将业务逻辑、加解密方式进行封装，减少线上联调、以及减少文档工作。

项目代号: `Carbon`, 因此在一些内部 Java 类之前会出现 `Carbon` 前缀，用于区分其他通用类型。

## 如何启动

```bash
# 编译并安装到本地仓库
mvn clean install

# 启动后端 Mock 服务用于接收推送数据
# 当收到推送数据后会在控制台打印显示
mvn spring-boot:run -pl carbon-mock-server

# 启动 Client 项目向 Mock 服务发送数据
mvn spring-boot:run -pl carbon-client-cli
```

## 如何使用


## Mock Server

用于本地调试，同时提供 OpenAPI 接口供调用方查询使用。用于演示服务端是如何收到，并处理数据的。

## FAQ

1. 我已经使用了https为什么还需要对报文进行加密
   > * 防止中间人攻击，或DNS劫持等情况
   > * 为了兼容老旧系统。如CA根证书未更新导致旧版JDK无法识别https中的证书。那么可以使用应用层加密+HTTP协议的方式来保证数据的安全性
2. 在交互过程中各种加密方法都是用来做什么的
   > * 对称加密: 用于加密报文中的数据，保证数据的机密性、不被外部窃听。看到的数据为密文
   > * 信息摘要: 用于保证数据的完整性，防止数据被篡改或损坏。（一般对称加密是按block加密，丢掉几个block仍然可以解密只是内容会不正确。而信息摘要是对整个数据进行摘要，可以发现这种篡改）
   > * 非对称加密: 用于保证数据的真实性、防止数据被伪造。（在非对称加密中：私钥加密只能公钥解密，公钥加密只能私钥解密。因此只要私钥未被泄漏，接收方如果能通过公钥解密数据就可以确认是私钥持有者发送的）
3. 支持的加密算法
   > * 对称加密: AES, SM4
   > * 信息摘要: SHA-256, SHA-512, SHA3-256, SHA3-512, MD5, SM3
   > * 非对称加密: RSA, SM2 (暂未实现)

## TODO

1. ~~将SDK包发布至 Maven Central Repository~~
2. 增加摘要的签名（非对称加密），用于保证数据的真实性
3. 支持服务端SDK。用于接收推送数据（推送至中介客户自建系统，需要在自建系统中引入该SDK）
4. 将国密作为可选项拆分为独立的模块，避免引入国密相关的依赖后导致和现有系统之间的冲突
5. 兼容支持使用 RestTemplate 作为 HTTP 客户端
