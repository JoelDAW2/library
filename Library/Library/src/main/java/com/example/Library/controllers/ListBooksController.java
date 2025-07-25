package com.example.Library.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Library.services.ListBooksService;

@RestController
@RequestMapping("/user")
public class ListBooksController {

    @Autowired
    private ListBooksService listBooksService;
    
    //Antiguos métidos de muestra de libros
/*
    @GetMapping("/read/user/{userId}")
    public List<String> findBooksReadByUser(@PathVariable Long userId) {
        return listBooksService.findBooksReadByUser(userId);
    }
    @GetMapping("/noReadsByUser/{userId}")
    public List<String> findBooksNoReadByUser(@PathVariable Long userId){
        return listBooksService.findBooksNoReadByUser(userId);
    }
*/
    @GetMapping("/{userId}")
    public List<Object>  mergeBooks(@PathVariable Long userId){
        return listBooksService.mergeBooks(userId);
    }
}