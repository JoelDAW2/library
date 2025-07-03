package com.example.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Library.models.Review;

@Repository
    public interface ReviewRepository extends JpaRepository<Review, Long>{

    }
