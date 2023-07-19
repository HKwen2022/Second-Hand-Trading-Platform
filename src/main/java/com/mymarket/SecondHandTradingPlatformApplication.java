package com.mymarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SecondHandTradingPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondHandTradingPlatformApplication.class, args);
    }

}
