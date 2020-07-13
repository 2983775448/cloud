package com.zj.controller;

import com.zj.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private ProductService productService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable(value = "id") int id){
        String result = productService.paymentInfo_ok(id);
        log.info("id:"+id+",ok"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable(value = "id") int id){
        String result = productService.paymentTimeOut(id);
        log.info("id:"+id+",timeout:");
        return result;
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = productService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
