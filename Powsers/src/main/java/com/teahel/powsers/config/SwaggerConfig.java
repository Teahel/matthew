package com.teahel.powsers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	/**
               * 创建API应用
     *apiInfo() 增加API相关信息
               * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
                * 采用指定扫描的包路径来定义指定要建立API的目录。    //添加注解的方式确定
     */
	@Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)//版本SWAGGER_2
        		.select()
        		.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        		.build();
    }
	
}

