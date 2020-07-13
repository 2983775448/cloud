package com.zj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = ProductServiceImpl.class)
public interface ProductService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable(value = "id") int id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable(value = "id") int id);

}
