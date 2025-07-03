package com.example.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.models.Book;
import com.example.Library.services.ListBooksService;

@RestController
@RequestMapping("/api/login/books")
public class ListBooksController {
    public List<Book> getAllBooksTitles(){
        return ListBooksService.getAllBooksTitles();
    }
}