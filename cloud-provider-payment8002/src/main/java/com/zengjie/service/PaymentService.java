package com.zengjie.service;

import com.zengjie.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zengjie
 * @date 2020/4/17 11:16
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
