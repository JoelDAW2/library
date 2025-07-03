package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Library.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String title);
}
