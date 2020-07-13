package com.zengjie.controller;

import com.zengjie.entities.CommonResult;
import com.zengjie.entities.Payment;
import com.zengjie.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengjie
 * @date 2020/4/17 11:23
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int number = paymentService.create(payment);
        log.info("****插入结果"+serverPort+number);
        if (number != 0){
            return new CommonResult(404,"插入数据成功",number);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查到的结果"+serverPort+payment);

        if (payment != null){
            return new CommonResult(404,"插入数据成功",payment);
        } else {
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feignTimeout")
    public String feignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "8002";
    }

}
