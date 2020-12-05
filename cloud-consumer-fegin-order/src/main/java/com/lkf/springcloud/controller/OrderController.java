package com.lkf.springcloud.controller;


import com.lkf.springcloud.bo.PaymentBO;
import com.lkf.springcloud.service.PaymentFeginService;
import com.lkf.springcloud.vo.CommPaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PaymentFeginService paymentFeginService;

    @GetMapping(value = "/query")
    public CommPaymentVO<PaymentBO> queryOrder(@RequestParam String id) {
        return paymentFeginService.query(Long.parseLong(id));
    }

}
