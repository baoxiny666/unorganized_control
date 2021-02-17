package com.lhtg.unorganized_control;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@MapperScan("com.lhtg.unorganized_control.mapper")
public class UnorganizedControlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UnorganizedControlApplication.class, args);
    }

    @Override
    protected  SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(UnorganizedControlApplication.class);
    }

}
