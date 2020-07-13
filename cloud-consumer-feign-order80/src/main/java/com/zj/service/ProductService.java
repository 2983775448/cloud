package com.zj.service;

import com.zengjie.entities.CommonResult;
import com.zengjie.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface ProductService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") long id);

    @GetMapping("/payment/feignTimeout")
    String feignTimeout(@PathVariable(value = "id")long id);

}
