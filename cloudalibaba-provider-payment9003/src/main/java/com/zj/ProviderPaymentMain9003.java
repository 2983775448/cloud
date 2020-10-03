package com.zj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9003.class,args);
    }
}
