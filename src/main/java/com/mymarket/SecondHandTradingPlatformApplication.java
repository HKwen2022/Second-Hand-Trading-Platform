package com.mymarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//@MapperScan(value = "com.mymarket.mapper")
@SpringBootApplication
public class SecondHandTradingPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondHandTradingPlatformApplication.class, args);
    }

}
