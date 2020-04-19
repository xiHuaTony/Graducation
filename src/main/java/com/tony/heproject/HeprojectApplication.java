package com.tony.heproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.tony.heproject.mapper")
public class HeprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeprojectApplication.class, args);
    }

}
