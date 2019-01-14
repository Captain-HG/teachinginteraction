package com.lzc.teachingInteraction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lzc.teachingInteraction.mapper")
@SpringBootApplication
public class TeachinginteractionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachinginteractionApplication.class, args);
    }

}

