package com.example.Library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Library.models.Book;
import com.example.Library.models.Review;

@Repository
    public interface ReviewRepository extends JpaRepository<Review, Long>{

        @Query(value="SELECT r FROM Review r Order by r.score desc")
        public List<Review> orderbyScore();
    }
