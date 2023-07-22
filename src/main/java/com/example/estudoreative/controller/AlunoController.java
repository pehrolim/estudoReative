package com.example.estudoreative.controller;

import com.example.estudoreative.AlunoDTO;
import com.example.estudoreative.service.AlunoIntegracaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoIntegracaoService alunoIntegracaoService;


    @GetMapping()
    public Flux<AlunoDTO> listaTodos(){
        return alunoIntegracaoService.fetchFluxDataFromExternalApi();
    }

    @GetMapping("/{id}")
    public Mono<AlunoDTO> findById(@PathVariable Long id){
        return alunoIntegracaoService.fetchDataFromExternalApi(id);
    }



}
