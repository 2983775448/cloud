package com.zj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CustomerController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/nacos/customer/payment/{id}")
    public String getPayment(@PathVariable("id") String id){
        String template = restTemplate.getForObject(serverUrl + "/nacos/provider/payment/" + id, String.class);
        return template+"....port:"+serverPort;
    }
}
