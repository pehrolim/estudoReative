package com.example.estudoreative.service;

import com.example.estudoreative.AlunoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlunoIntegracaoService {

    private final WebClient webClient;

    public AlunoIntegracaoService(){
        this.webClient = WebClient.create("http://localhost:8080");
    }

    public Mono<AlunoDTO> fetchDataFromExternalApi(Long id){
        return webClient.get()
                .uri("/alunos/" + id)
                .retrieve()
                .bodyToMono(AlunoDTO.class)
                .flatMap(response -> {
                    if (response != null) {
                        return Mono.just(response);
                    }else {
                        return Mono.empty();
                    }
                });
    }

    public Flux<AlunoDTO> fetchFluxDataFromExternalApi(){
        return webClient.get()
                .uri("/alunos")
                .retrieve()
                .bodyToFlux(AlunoDTO.class)
                .flatMap(response -> {
                    if (response != null) {
                        return Flux.just(response);
                    }else {
                        return Flux.empty();
                    }
                });
    }

}
