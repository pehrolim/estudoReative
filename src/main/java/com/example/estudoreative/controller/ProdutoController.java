package com.example.estudoreative.controller;

import com.example.estudoreative.model.Produto;
import com.example.estudoreative.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> listarTodos(){
        return produtoService.lisatarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Produto> listar(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public Mono<Produto> salvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
    @DeleteMapping
    public Mono<Void> deletar(@PathVariable Long id){
        return produtoService.deletar(id);
    }

}
