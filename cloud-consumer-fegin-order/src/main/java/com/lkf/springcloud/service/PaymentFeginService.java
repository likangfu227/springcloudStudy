package com.lkf.springcloud.service;

import com.lkf.springcloud.bo.PaymentBO;
import com.lkf.springcloud.vo.CommPaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author lkf
 * @Date 2020/11/28 22:47
 * @description：fengin调用
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeginService {

    @GetMapping(value = "/payment/query/{id}")
    public CommPaymentVO<PaymentBO> query(@PathVariable("id") Long id);
}
