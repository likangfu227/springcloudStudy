package com.lkf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author lkf
 * @Date 2020/11/28 21:08
 * @description：自定义负载
 */
public interface LoadBalance {

    public ServiceInstance getLoadBalance(List<ServiceInstance> instances);
}
