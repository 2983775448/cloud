package com.zengjie.controller;

import com.zengjie.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * @author zengjie
 * @date 2020/4/17 11:23
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String create(){
        return "springcloud with consul:"+ LocalDateTime.now().toString();
    }

}
