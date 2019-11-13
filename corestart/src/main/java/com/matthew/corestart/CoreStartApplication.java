package com.matthew.corestart;

import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
        import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.matthew.**.mapper")
@ComponentScan("com.matthew")
@SpringBootApplication
public class CoreStartApplication extends SpringBootServletInitializer {

    // 重写 configure方法（打包）
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(CoreStartApplication.class);
    }

    //保持不变
    public static void main(String[] args) {
        SpringApplication.run(CoreStartApplication.class, args);
    }

}
