package com.lkf.springcloud.service.impl;

import com.lkf.springcloud.bo.PaymentBO;
import com.lkf.springcloud.dao.PaymentDao;
import com.lkf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(PaymentBO paymentBO) {
        return paymentDao.create(paymentBO);
    }

    @Override
    public PaymentBO queryPaymentById(Long id) {
        return paymentDao.queryPaymentById(id);
    }
}
