package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.Library.models.Book;

public interface ListBooksRepository extends JpaRepository<Book, Long>{
    @Query("select b.title from Books b") 
    public List<Book> getAllBooksTitles();
}
