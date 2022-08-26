package com.dp.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EchoController {

    static String HELLO_WORLD = "Hello World";

    @GetMapping("/echo/mono")
    public Mono<String> echo() {
        return Mono.just(HELLO_WORLD);
    }

    @GetMapping("/echo/str")
    public String echoStr() {
        return HELLO_WORLD;
    }
}
