package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.Library.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    @Query("SELECT b.title FROM Book b WHERE b.title like %:frag%")
    List<String> findByTitle(@Param("frag") String frag);
}
