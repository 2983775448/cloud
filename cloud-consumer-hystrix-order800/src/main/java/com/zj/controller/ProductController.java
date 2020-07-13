package com.zj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zj.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutFallback")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/customer/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable(value = "id") int id){
        String result = productService.paymentInfo_Ok(id);
        log.info("customer hystric ok:"+result);
        return result;
    }

    @GetMapping("/customer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback",
            commandProperties = {@HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_TimeOut(@PathVariable(value = "id") int id){
//        int a = 10/0;
        String result = productService.paymentInfo_TimeOut(id);
        log.info("customer hystric timeout:"+result);
        return result;
    }

    private String paymentInfo_TimeOutFallback(int id){
        return "800 服务器异常或系统内部遇到错误，请稍后再试";
    }
}
