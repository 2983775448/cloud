package com.zengjie.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zengjie
 * @date 2020/4/21 21:10
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current ;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >=Integer.MAX_VALUE ? 0 : current+1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
