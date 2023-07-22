package com.example.estudoreative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;


@ComponentScan({"com.example.estudoreative.repository", "com.example.estudoreative.controller", "com.example.estudoreative.service"})
@EnableR2dbcRepositories
@SpringBootApplication
public class EstudoReativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoReativeApplication.class, args);
	}

}
