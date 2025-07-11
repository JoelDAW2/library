package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Library.models.Review;

@Repository
    public interface ReviewRepository extends JpaRepository<Review, Long>{
        @Query("SELECT u.username, b.title, r.comment, r.score FROM User u JOIN Review r ON u.id = r.userId join Book b on b.id = r.bookId")
        List<String> showReview();
        
        @Query("SELECT b.title, AVG(r.score) FROM Review r inner join Book b ON b.id = r.bookId group by b.title order by AVG(r.score) desc")
        public List<String> orderbyScore();

        @Query("SELECT b.title,r.score, r.comment FROM User u JOIN Review r ON u.id = r.userId join Book b on b.id = r.bookId WHERE r.userId = :userId")
        public List<String> IdUserReviews(@Param("userId") Long userId);

        @Query("SELECT u.username, b.title,r.score, r.comment FROM User u JOIN Review r ON u.id = r.userId join Book b on b.id = r.bookId WHERE u.username like %:username% order by u.username")
        public List<String> UserNameReviews(@Param("username") String username);

        @Query("SELECT u.username,b.title,r.score, r.comment FROM User u JOIN Review r ON u.id = r.userId join Book b on b.id = r.bookId WHERE b.title like %:bookName% order by b.title")
        public List<String> BookReviews(@Param("bookName") String bookName);

    } 
