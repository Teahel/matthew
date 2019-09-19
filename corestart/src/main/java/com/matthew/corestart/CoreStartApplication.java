package com.matthew.corestart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.matthew.**.mapper")
@ComponentScan("com.matthew")
@SpringBootApplication
public class CoreStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreStartApplication.class, args);
    }

}
