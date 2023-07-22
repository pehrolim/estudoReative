package com.example.estudoreative.controller;

import com.example.estudoreative.model.Book;
import com.example.estudoreative.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public Flux<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable Long id){
        return bookRepository.findById(id);
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBook(@PathVariable Long id){
        return bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setTitle((book.getTitle()));
                    existingBook.setAuthor(book.getAuthor());
                    return bookRepository.save(existingBook);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Livro não encontrado com o id: " + id)));
    }

}
