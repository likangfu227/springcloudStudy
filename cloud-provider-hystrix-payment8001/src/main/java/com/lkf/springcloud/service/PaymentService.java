package com.lkf.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author lkf
 * @Date 2020/11/29 21:52
 * @description：支付service
 */
@Component
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK,id" + id + " (*^_^*)";
    }

    /**
     * 超过3秒会服务降级，调用fallbackMethod方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout,id" + id + " (*^_^*) 耗时:" + time + "秒";
    }

    public String paymentInfo_Timeout_handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout_handler,id" + id + " /(ㄒoㄒ)/~~ ";

    }
}
