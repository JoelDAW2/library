package com.example.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.models.Book;
import com.example.Library.services.BookService;

/*Para hacer test, ejecutar './mvnw spring-boot:run' dentro de la carpeta Library y ir a esta 
URL: http://localhost:8080/helloWorld helloWorld puede cambiar si se edita el /helloWorld de @getMapping */

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/bookByName") // se accede con: http://localhost:8080/api/books/bookByName?title=titulo%del%libro
    public Book findBookByTitle(@RequestParam String title){
        return bookService.findBookByTitle(title);
    }
    @PutMapping
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }   
}
