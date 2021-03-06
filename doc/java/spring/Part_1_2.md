## Introduction to the Spring Framework

### Dependency Injection and Inversion of Control

Java应用中的对象相互依赖，Java平台本身缺乏组织基本构建模块的能力，虽然有如Factory，AbstractFactory，Builder，Decorator等设计模式及服务定位器
但是他需要自己去实现。Spring框架的IoC正是为了解决这个问题

### Modules

```text
    +---------------------------+ +---------------------------+
    |  Data Access/Integration  | |           Web             |
    | +----------+ +----------+ | |                           |
    | |   JDBC   | |    ORM   | | | +-----------+ +---------+ |
    | +----------+ +----------+ | | | WebSocket | | Servlet | |
    | +----------+ +----------+ | | +-----------+ +---------+ |
    | |    OXM   | |    JMS   | | |                           |
    | +----------+ +----------+ | | +---------+   +---------+ |
    | +-----------------------+ | | |   Web   |   | Portlet | |
    | |     Transactions      | | | +-------=-+   +---------+ |
    | +-----------------------+ | |                           |
    +---------------------------+ +---------------------------+
    +-----+   +---------+   +-----------------+   +-----------+
    | AOP |   | Aspects |   | Instrumentation |   | Messaging |
    +-----+   +---------+   +-----------------+   +-----------+
    +---------------------------------------------------------+
    |                       Core Container                    |
    |  +---------+  +----------+  +-----------+  +----------+ |
    |  |  Beans  |  |   Core   |  |  Context  |  |   SpEL   | |
    |  +---------+  +----------+  +-----------+  +----------+ |
    +---------------------------------------------------------+
    +---------------------------------------------------------+
    |                           Test                          |
    +---------------------------------------------------------+
```

#### Core Container

spring-core和spring-beans组成了框架的基础，包含IoC（控制反转）和DI（依赖注入）。BeanFactory是工程模式的一个复杂实现

spring-context建立在core和beans提供的坚实基础之上。它继承了Beans模块的功能，并增加了对它的国际化（如使用资源包），事件传播，资源加载透明的创建上下文，例如通过一个Servlet容器。
也支持Javas EE 特性，如EJB，JMX和基本的远程调用。ApplicationContext接口是context的焦点。

spring-context-support为集成常见的第三方库提供支持，如缓存（EhCache，Guava，JCache），邮件（JavaMail），计划（CommonJ，Quartz）以及模板引擎（FreeMarker，JasperReports，Velocity）

spring-expression是JSP 2.1中定义的统一表达式语言的扩展

#### AOP and Instrumentation

spring-aop提供了面向切面编程的能力，spring-aspects提供了对AspectJ的集成。
spring-instrument提供了类的仪表盘支持和在特定容器中使用的类加载器实现。spring-instrument-tomcat提供了Tomcat的Spring仪表盘代理

#### Messaging

spring-messaging，包含关键抽象如Message，MessageChannel，MesageHandler等其他内容，来为基于消息的引用提供基础服务
同时包含了注解映射消息到方法，类似于Spring MVC基于注解编程模型

#### Data Access/Integration

spring-jdbc 提供了JDBC抽象层，从而无需JDBC的繁琐代码和对数据库提供商定义的错误码的解析

spring-tx 对实现特定接口的类和所有POJOs提供编程式和声明式事务管理

spring-orm 提供常见对象关系映射API的集成层，包括JPA，JDO和Hibernate。使用spring-orm可以将所有这些O/R mapping框架和其他Spring提供的特性结合使用，例如简单的声明式事务管理

spring-oxm 模块提供了对象/XML映射实现的抽象层，如JAXB，Castor，XMLBeans，JiBX和XStream

spring-jms 包含了生产和消费消息的能力，从4.1版本，在spring-messaging模块里集成

#### Web

spring-web 提供了基本的web向集成，如多文件上传，使用Servlet监听器初始化IoC容器及web向的应用上下文。同事也包括HTTP客户端和web相关的spring远程调用支持。

spring-webmvc模块（也称为web-servlet模块）包含包含了spring的model-view-controller和REST Web Services实现。

spring-webmvc-portlet（也称为web-portlet模块）提供了在Portlet环境中的MVC实现和spring-webmvc模块的镜像功能

#### Test

spring-test提供了单元测试和Spring组件与JUnit或TestNG测试的集成。提供加载Spring应用上下文和上下文缓存，提供模拟对象用来单独的测试代码

### Usage scenarios

#### Dependency Management and Naming Conventions

#### Logging

##### Not Using Commons Logging

##### Using SLF4J

```xml
<dependencies>
 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-core</artifactId>
 <version>4.3.6.RELEASE</version>
 <exclusions>
 <exclusion>
 <groupId>commons-logging</groupId>
 <artifactId>commons-logging</artifactId>
 </exclusion>
 </exclusions>
 </dependency>
 <dependency>
 <groupId>org.slf4j</groupId>
 <artifactId>jcl-over-slf4j</artifactId>
 <version>1.5.8</version>
 </dependency>
 <dependency>
 <groupId>org.slf4j</groupId>
 <artifactId>slf4j-api</artifactId>
 <version>1.5.8</version>
 </dependency>
 <dependency>
 <groupId>org.slf4j</groupId>
 <artifactId>slf4j-log4j12</artifactId>
 <version>1.5.8</version>
 </dependency>
 <dependency>
 <groupId>log4j</groupId>
 <artifactId>log4j</artifactId>
 <version>1.2.14</version>
 </dependency>
</dependencies>
```

##### Using Log4j

使Log4j与默认的JCL依赖一同工作，只需要将Log4j放到classpath上，并提供配置文件（classpath根目录下的log4j.properties或log4j.xml）

```xml
<dependencies>
 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-core</artifactId>
 <version>4.3.6.RELEASE</version>
 </dependency>
 <dependency>
 <groupId>log4j</groupId>
 <artifactId>log4j</artifactId>
 <version>1.2.14</version>
 </dependency>
</dependencies>
```

下面是一个记录日志到控制台上的示例log4j.properties：

```properties
log4j.rootCategory=INFO,stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %t %c{2}:%L - %m%n

log4j.category.org.springframework.bean.factory=DEBUG
```

Log4j 2与JCL一同使用，需要讲Log4j添加到classpath上，并添加配置文件（log4j2.xml，log4j2.properties或其他[支持的格式](http://logging.apache.org/log4j/2.x/manual/configuration.html)）。
对于Maven的使用者，最少依赖如下：
```xml
<dependencies>
 <dependency>
 <groupId>org.apache.logging.log4j</groupId>
 <artifactId>log4j-core</artifactId>
 <version>2.7</version>
 </dependency>
 <dependency>
 <groupId>org.apache.logging.log4j</groupId>
 <artifactId>log4j-jcl</artifactId>
 <version>2.7</version>
 </dependency>
</dependencies>
```
如果你还想使用SLF4J，那么下面的依赖也需要：
```xml
<dependencies>
 <dependency>
 <groupId>org.apache.logging.log4j</groupId>
 <artifactId>log4j-slf4j-impl</artifactId>
 <version>2.7</version>
 </dependency>
</dependencies>
```
如下是一个示例log4j2.xml，日志打到控制台上：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
 <Appenders>
 <Console name="Console" target="SYSTEM_OUT">
 <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
 </Console>
 </Appenders>
 <Loggers>
 <Logger name="org.springframework.beans.factory" level="DEBUG"/>
 <Root level="error">
 <AppenderRef ref="Console"/>
 </Root>
 </Loggers>
</Configuration>
```

##### Runtime Containers with Native JCL

