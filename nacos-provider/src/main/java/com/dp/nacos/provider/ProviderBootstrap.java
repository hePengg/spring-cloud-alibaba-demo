package com.dp.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
public class ProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class, args);
    }
}