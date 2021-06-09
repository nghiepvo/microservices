# User Service  

#### Initial User Service project  

We should go to https://start.spring.io/  for generate new project or 
creating by IntelliJ IDEA tool.
 
_Note_: 
1. For run with command line:  
> mvn spring-boot:run
2. Change Port, Goto resources > application.properties
Append line:
> server.port=8001  
#### Setting up auto compiler

In IDEA tool  
1. **[Press Ctl + Shift + a]** or **[Menu > Help > Find Action]** > Select **Registry...** and then checked on **compiler.automake.allow.when.app.running**  
2. **[Press Ctl + Alt + s]** or **[Menu > File > Setting]** > Select **Build, Execution, Deployment** > Select **Compiler** and then checked on **Build project automatically**

In the Code  
Append some line code bellow to pom.xml  
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```
#### User 3-tier design  
[Presentation Layer] --> [Service Layer] --> [Data Access Layer]

Add 2 libraries   

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
And a configuration connection string to resources > application.properties.
```
spring.h2.console.enabled=true  
spring.datasource.url=jdbc:h2:mem:userdb  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=password  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
```

And verify by the way goto http://localhost:8001/h2-console

verify and test connection, make sure that it will be matched with your configuration.