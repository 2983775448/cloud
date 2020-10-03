package com.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/provider/payment/{id}")
    public String getPayment(@PathVariable("id") String id){
        return "nacos....provider....payment.....id:"+id+"....port:"+serverPort;
    }
}
