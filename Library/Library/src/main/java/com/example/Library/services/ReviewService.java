package com.example.Library.services;

import java.util.List;
import com.example.Library.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Library.models.Review;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository ReviewRepository;

    public Review createReview(Review review){
        return ReviewRepository.save(review);
    }

    public List<Review> getAllReview(){
        return ReviewRepository.findAll();
    }
}