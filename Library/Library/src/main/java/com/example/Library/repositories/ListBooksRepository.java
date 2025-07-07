package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Library.models.Book;

public interface ListBooksRepository extends JpaRepository<Book, Long>{
    @Query("SELECT b.title FROM Book b JOIN Review r ON b.id = r.bookId WHERE r.userId = :userId")
    List<String> findBooksReadByUser(@Param("userId") Long userId);
    @Query("SELECT b.id, b.title FROM Book b JOIN Review r ON b.id = r.bookId WHERE NOT r.userId = :userId")
    List<String> findBooksNoReadByUser(@Param("userId") Long userId);
}
