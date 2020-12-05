package com.lkf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lkf
 * @Date 2020/11/28 21:29
 * @description：轮询负载均衡
 */
@Component
public class MyLoadBalance implements LoadBalance {

    private AtomicInteger count = new AtomicInteger(0);

    public final int getCurrentCount() {
        int current;
        int next;
        do {
            current = count.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!count.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance getLoadBalance(List<ServiceInstance> instances) {
        int count = getCurrentCount();
        int sum = instances.size();
        int n = count % sum;
        return instances.get(n);
    }
}
