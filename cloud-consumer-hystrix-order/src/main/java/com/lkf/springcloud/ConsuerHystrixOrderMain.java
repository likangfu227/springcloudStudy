package com.lkf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lkf
 * @Date 2020/11/29 23:33
 * @description：主启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
public class ConsuerHystrixOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsuerHystrixOrderMain.class, args);
    }
}
