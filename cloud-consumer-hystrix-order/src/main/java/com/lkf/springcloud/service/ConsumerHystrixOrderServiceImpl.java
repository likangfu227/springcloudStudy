package com.lkf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author lkf
 * @Date 2020/11/30 22:46
 * @description： 兜底类
 */
@Component
public class ConsumerHystrixOrderServiceImpl implements ConsumerHystrixOrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "系统繁忙，请稍后再试";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "系统繁忙，请稍后再试";
    }
}
