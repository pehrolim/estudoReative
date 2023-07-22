package com.example.estudoreative.teste;

import java.util.Arrays;
import java.util.List;

public class ExemploStream {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int somaDosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer :: intValue)
                .sum();

        System.out.println("A soma dos números pares : " + somaDosPares);
    }
}
