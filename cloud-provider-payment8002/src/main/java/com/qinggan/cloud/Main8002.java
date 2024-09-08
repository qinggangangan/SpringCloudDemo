package com.qinggan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description: ${DESCRIPTION}
 * Author: ${USER}
 * Date: ${DATE} ${TIME}
 */
@SpringBootApplication
@MapperScan("com.qinggan.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope // 动态刷新
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class,args);
    }
}