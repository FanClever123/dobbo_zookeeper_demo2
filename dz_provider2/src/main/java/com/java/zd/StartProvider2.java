package com.java.zd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 * author:樊聪
 * time: 2020/4/12 10:21
 */
@SpringBootApplication
@MapperScan(basePackages = "com.java.zd.mapper")
public class StartProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(StartProvider2.class);
    }
}
