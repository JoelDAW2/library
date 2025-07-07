package com.example.Library.services;

import java.util.List;
import com.example.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library.models.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public String getBooksTitle(Book book){
        return book.getTitle();
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        
        if(book != null)
        {
            return book;
        }
        else 
        {
            return null;
        }
    }
}
