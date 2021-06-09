# User Service  

#### Initial User Service project  

We should go to https://start.spring.io/  for generate new project or 
creating by IntelliJ IDEA tool.
 
_Note_: For run with command line:  
> mvn spring-boot:run
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
