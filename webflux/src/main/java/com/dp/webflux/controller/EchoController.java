package com.dp.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EchoController {

    static String HELLO_WORLD = "Hello World";

    @GetMapping("/echo/mono")
    public Mono<String> echoMono() {
        return Mono.just(HELLO_WORLD);
    }

    @GetMapping("/echo/flux")
    public Flux<String> echoFlux() {
        return Flux.just(HELLO_WORLD, HELLO_WORLD, HELLO_WORLD);
    }

    @GetMapping("/echo/str")
    public String echoStr() {
        return HELLO_WORLD;
    }
}
