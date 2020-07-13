package com.zj.controller;

import com.zengjie.entities.CommonResult;
import com.zengjie.entities.Payment;
import com.zj.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/customer/payment/get/{id}")
    public CommonResult get(@PathVariable(value = "id") long id){
        CommonResult<Payment> payment = productService.getPaymentById(id);
        log.info("当前信息:"+payment.toString());
        return payment;
    }

    @RequestMapping("/customer/payment/feignTimeout/{id}")
    public String feignTimeout(@PathVariable(value = "id") int id){
        String feignTimeout = productService.feignTimeout(id);
        return feignTimeout;
    }

}
