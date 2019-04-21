package com.lzc.teachingInteraction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.lzc.teachingInteraction.mapper")
@SpringBootApplication
@EnableTransactionManagement
//@EnableRabbit         //开启rabbit的注解方式
public class TeachinginteractionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachinginteractionApplication.class, args);
    }

}

