package com.java.zd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 * author:樊聪
 * time: 2020/4/12 10:20
 */
@SpringBootApplication
@MapperScan(basePackages = "com.java.zd.mapper")
public class StartProvider1 {
    public static void main(String[] args) {
        SpringApplication.run(StartProvider1.class);
    }
}
