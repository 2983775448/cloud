package com.zengjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zengjie
 * @date 2020/4/20 20:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain80.class,args);
    }
}
