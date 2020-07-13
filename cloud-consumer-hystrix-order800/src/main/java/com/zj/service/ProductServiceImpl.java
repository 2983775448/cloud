package com.zj.service;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{
    @Override
    public String paymentInfo_Ok(int id) {
        return "服务器异常：paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "服务器异常：paymentInfo_TimeOut";
    }
}
