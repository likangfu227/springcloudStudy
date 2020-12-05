package com.lkf.springcloud.controller;

import com.lkf.springcloud.service.ConsumerHystrixOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author lkf
 * @Date 2020/11/29 23:38
 * @description：controller
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class ConsumerHystrixOrderController {

    @Resource
    private ConsumerHystrixOrderService consumerHystrixOrderService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return consumerHystrixOrderService.paymentInfo_OK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
        return consumerHystrixOrderService.paymentInfo_Timeout(id);
    }
}
