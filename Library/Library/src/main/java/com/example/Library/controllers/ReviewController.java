package com.example.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.models.Review;
import com.example.Library.services.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController{

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }

    @GetMapping
    public List<String> showReview(){
        return reviewService.showReview();
    }

    @GetMapping("/orderbyAVGScore")
        public List<String> orderbyScore(){
        return reviewService.orderbyScore();
    }

    @GetMapping("/IdUserReviews_{userId}")
        public List<String> IdUserReviews(@PathVariable Long userId){
        return reviewService.IdUserReviews(userId);
    }

     @GetMapping("/UserNameReviews_{username}")
     public List<String> UserNameReviews(@PathVariable String username){
        return reviewService.UserNameReviews(username);
    }
}