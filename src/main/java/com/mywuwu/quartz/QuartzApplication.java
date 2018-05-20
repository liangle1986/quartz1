package com.mywuwu.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@EnableAutoConfiguration
@MapperScan("com.mywuwu.quartz.dao")
@SpringBootApplication
public class QuartzApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//         注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(QuartzApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

}
