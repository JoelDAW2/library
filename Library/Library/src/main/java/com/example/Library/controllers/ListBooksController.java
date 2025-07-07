package com.example.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.services.ListBooksService;

@RestController
@RequestMapping("/api/books")
public class ListBooksController {

    @Autowired
    private ListBooksService listBooksService;
    
    @GetMapping("/read/user/{userId}")
    public List<String> findBooksReadByUser(@PathVariable Long userId) {
        return listBooksService.findBooksReadByUser(userId);
    }
    @GetMapping("/noread/user/{userId}")
    public List<String> findBooksNoReadByUser(@PathVariable Long userId){
        return listBooksService.findBooksNoReadByUser(userId);
    }
}