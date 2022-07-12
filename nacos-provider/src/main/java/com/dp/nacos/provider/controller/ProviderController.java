package com.dp.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("/echo/{str}")
    private String echo(@PathVariable String str) {
        return "Provide response :" + str;
    }
}
