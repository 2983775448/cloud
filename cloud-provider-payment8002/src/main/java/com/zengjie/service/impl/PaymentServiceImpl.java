package com.zengjie.service.impl;

import com.zengjie.dao.PaymentDao;
import com.zengjie.entities.Payment;
import com.zengjie.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zengjie
 * @date 2020/4/17 11:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
