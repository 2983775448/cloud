package com.zengjie.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zengjie
 * @date 2020/4/21 21:07
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
