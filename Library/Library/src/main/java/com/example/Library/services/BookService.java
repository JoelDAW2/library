package com.example.Library.services;

import java.util.List;
import com.example.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Library.models.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository BookRepository;

    public Book createBook(Book book){
        return BookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return BookRepository.findAll();
    }
}
