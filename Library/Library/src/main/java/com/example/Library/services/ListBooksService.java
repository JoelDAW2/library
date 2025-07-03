package com.example.Library.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library.models.Book;
import com.example.Library.repositories.ListBooksRepository;

@Service
public class ListBooksService {

    public List<Book> getAllBooksTitles(){
        return ListBooksRepository.getAllBooksTitles();
    }
}
