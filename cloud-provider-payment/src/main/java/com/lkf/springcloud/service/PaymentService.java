package com.lkf.springcloud.service;

import com.lkf.springcloud.bo.PaymentBO;

public interface PaymentService {
    /**
     * 保存
     *
     * @param paymentBO
     * @return
     */
    int create(PaymentBO paymentBO);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    PaymentBO queryPaymentById(Long id);
}
