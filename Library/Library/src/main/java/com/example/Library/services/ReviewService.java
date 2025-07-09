package com.example.Library.services;

import java.util.List;
import com.example.Library.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Library.models.Review;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository ReviewRepository;

    public Review createReview(Review review){
        return ReviewRepository.save(review);
    }

    public List<String> showReview() {
        List<String> showReviews = ReviewRepository.showReview();
        return showReviews;
    }
    public List<String> orderbyScore(){
        return ReviewRepository.orderbyScore();
    }

    public List<String> IdUserReviews(@PathVariable Long userId){
        return ReviewRepository.IdUserReviews(userId);
    }

     public List<String> UserNameReviews(@PathVariable String username){
        return ReviewRepository.UserNameReviews(username);
    }
}

