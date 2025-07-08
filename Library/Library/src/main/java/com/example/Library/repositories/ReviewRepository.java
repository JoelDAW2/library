package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Library.models.Review;

@Repository
    public interface ReviewRepository extends JpaRepository<Review, Long>{
        @Query("SELECT u.name, r.comment, r.score FROM User u JOIN Review r ON u.id = r.userId")
        List<String> showReview();
        //@Query("SELECT b.title, AVG(r.score) FROM Review r inner join Book b ON b.id = r.bookId group by r.bookID order by AVG(r.score) desc")
        @Query("SELECT b.title, AVG(r.score) FROM Review r inner join Book b ON b.id = r.bookId group by b.title order by AVG(r.score) desc")
        public List<String> orderbyScore();
    }
