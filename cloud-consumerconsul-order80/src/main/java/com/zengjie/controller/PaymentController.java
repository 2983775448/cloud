package com.zengjie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zengjie
 * @date 2020/4/20 20:05
 */
@RestController
@Slf4j
public class PaymentController {

    private final static String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate template;

    @GetMapping("/consumer/payment/consul")
    public String create(){
        String message = template.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return message;
    }

}
