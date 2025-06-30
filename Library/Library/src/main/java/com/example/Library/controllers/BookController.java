package com.example.Library.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BookController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "¡Hola desde Spring boot!";
    }
    
}
