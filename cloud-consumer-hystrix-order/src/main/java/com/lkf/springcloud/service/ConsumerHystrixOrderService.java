package com.lkf.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author lkf
 * @Date 2020/11/29 23:35
 * @description：接口
 */
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = ConsumerHystrixOrderServiceImpl.class)
public interface ConsumerHystrixOrderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
