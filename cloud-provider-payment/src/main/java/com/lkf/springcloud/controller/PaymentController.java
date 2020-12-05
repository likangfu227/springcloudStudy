package com.lkf.springcloud.controller;


import com.lkf.springcloud.bo.PaymentBO;
import com.lkf.springcloud.service.PaymentService;
import com.lkf.springcloud.vo.CommPaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 保存
     *
     * @param paymentBO
     * @return
     */
    @PostMapping(value = "/create")
    public CommPaymentVO create(@RequestBody PaymentBO paymentBO) {
        int result = paymentService.create(paymentBO);
        if (result > 0) {
            return new CommPaymentVO(200, "数据插入成功");
        } else {
            return new CommPaymentVO(444, "数据插入失败");
        }
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/query/{id}")
    public CommPaymentVO<PaymentBO> query(@PathVariable("id") Long id) {
        PaymentBO paymentBO = paymentService.queryPaymentById(id);
        if (paymentBO != null) {
            log.info("数据查询成功，端口为：" + serverPort);
            return new CommPaymentVO(200, "数据查询成功,端口：" + serverPort, paymentBO);
        } else {
            return new CommPaymentVO(444, "数据插入失败", null);
        }
    }

    @GetMapping(value = "/getDiscovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
