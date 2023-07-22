package com.example.estudoreative.service;

import com.example.estudoreative.model.Produto;
import com.example.estudoreative.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Flux<Produto> lisatarTodos(){
        return produtoRepository.findAll();
    }

    public Mono<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Mono<Produto> salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Mono<Void> deletar(Long id){
        return produtoRepository.deleteById(id);
    }

}
