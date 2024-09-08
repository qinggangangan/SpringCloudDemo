package com.qinggan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: ${DESCRIPTION}
 * Author: ${USER}
 * Date: ${DATE} ${TIME}
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class,args);
    }
}