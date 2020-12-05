package com.lkf.springcloud.controller;

import com.lkf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lkf
 * @Date 2020/11/29 21:57
 * @description：支付controller
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("------result----:" + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("------result----:" + result);
        return result;
    }
}
