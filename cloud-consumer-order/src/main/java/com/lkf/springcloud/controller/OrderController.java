package com.lkf.springcloud.controller;


import com.lkf.springcloud.bo.PaymentBO;
import com.lkf.springcloud.lb.LoadBalance;
import com.lkf.springcloud.vo.CommPaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    //服务名
    private static final String BASE_URL = "http://cloud-payment-service";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/query")
    public CommPaymentVO<PaymentBO> queryOrder(@RequestParam String id) {
        ResponseEntity<CommPaymentVO> forEntity = restTemplate.getForEntity(BASE_URL + "/payment/query/" + id, CommPaymentVO.class);
        return forEntity.getBody();
    }

    /**
     * 自定义的轮询负载均衡
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/query/myLoadBalance")
    public CommPaymentVO<PaymentBO> queryOrderByMyLoadBalance(@RequestParam String id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance loadBalance = this.loadBalance.getLoadBalance(instances);
        System.out.println(loadBalance.getUri());
        ResponseEntity<CommPaymentVO> forEntity = restTemplate.getForEntity(loadBalance.getUri() + "/payment/query/" + id, CommPaymentVO.class);
        return forEntity.getBody();
    }

}
