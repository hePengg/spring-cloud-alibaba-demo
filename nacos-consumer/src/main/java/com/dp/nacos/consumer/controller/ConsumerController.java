package com.dp.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public static final String APP_NAME = "nacos-provider";


    /**
     * Consumer
     */
    @GetMapping("/_call/{str}")
    public String callProvider(@PathVariable String str) {
        String url = "http://" + APP_NAME + "/echo/" + str;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/instances/{serviceName}")
    public ServiceInstance getInstances(@PathVariable String serviceName)  {
        return loadBalancerClient.choose(serviceName);
    }
}
