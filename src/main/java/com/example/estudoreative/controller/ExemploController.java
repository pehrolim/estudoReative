package com.example.estudoreative.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ExemploController {

    @GetMapping("/fluxo")
    public Flux<Integer> exemploFluxo(){
        return Flux.just(1,2,3,4,5);
    }

}
