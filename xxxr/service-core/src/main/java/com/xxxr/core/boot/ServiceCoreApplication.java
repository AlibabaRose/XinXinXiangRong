package com.xxxr.core.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.xxxr.base.config"})
@MapperScan("com.xxxr.core.boot.mapper")
public class ServiceCoreApplication {

    public static void main(String[] args) {
            SpringApplication.run(ServiceCoreApplication.class, args);
    }
}