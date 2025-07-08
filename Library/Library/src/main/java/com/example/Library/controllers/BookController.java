package com.example.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.models.Book;
import com.example.Library.services.BookService;
import com.example.Library.utils.CsvGeneratorUtil;

import org.springframework.http.MediaType;

/*Para hacer test, ejecutar './mvnw spring-boot:run' dentro de la carpeta Library y ir a esta 
URL: http://localhost:8080/helloWorld helloWorld puede cambiar si se edita el /helloWorld de @getMapping */

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CsvGeneratorUtil csvGeneratorUtil;

    /* @GetMapping("/employees/csv")
    public ResponseEntity<byte[]> generateCsvFile() {

    } */

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/findByTitle") // se accede con: http://localhost:8080/api/books/bookByName?title=titulo%del%libro
    public List<String> findByTitle(@RequestParam String title){
        return bookService.findByTitle(title);
    }
    @PutMapping
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    } 
    
    @GetMapping("/csv")
    public ResponseEntity<byte[]> generateCsvFile() {
        List<Book> books = bookService.getAllBooks();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "books.csv");

        byte[] csvBytes = csvGeneratorUtil.generateCsv(books).getBytes();

        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }
}
