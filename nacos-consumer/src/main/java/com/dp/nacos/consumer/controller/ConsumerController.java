package com.dp.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String APP_NAME = "mall-order";

    /**
     * Consumer
     */
    @GetMapping("/_call/{str}")
    public String callProvider(@PathVariable String str) {
        String url = "http://" + APP_NAME + "/echo/" + str;
        return restTemplate.getForObject(url, String.class);
    }
}
