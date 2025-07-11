package com.example.Library.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        List<String> a = reviewService.showReview();

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += "Username: ";

            String b= a.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount <= 3) {
                    switch (comasCount) {
                        case 0:
                        ret.add(Bonus);
                            Bonus = "Title: ";
                        break;
                        case 1:
                        ret.add(Bonus);
                            Bonus = "Score: ";
                        break;
                        case 2: 
                        ret.add(Bonus);
                            Bonus = "Review: ";
                        break;
                    }
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < a.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;
    }

    @GetMapping("/orderbyAVGScore")
    public List<String> orderbyScore(){

        List<String> a = reviewService.orderbyScore();

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += "Title: ";

            String b= a.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount <= 1) {
                    switch (comasCount) {
                        case 0:
                        ret.add(Bonus);
                            Bonus = "Score: ";
                        break;
                    }
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < a.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;
        
    }

    @GetMapping("/IdUserReviews_{userId}")
        public List<String> IdUserReviews(@PathVariable Long userId){
        List<String> a = reviewService.IdUserReviews(userId);

                List<String> ret = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += "Title: ";

            String b= a.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount <= 2) {
                    switch (comasCount) {
                        case 0:
                        ret.add(Bonus);
                            Bonus = "Score: ";
                        break;
                        case 1: 
                        ret.add(Bonus);
                            Bonus = "Review: ";
                        break;
                    }
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < a.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;
        
    }

    @GetMapping("/UserNameReviews_{username}")
    public List<String> UserNameReviews(@PathVariable String username){
        List<String> a = reviewService.UserNameReviews(username);

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += "Username: ";

            String b= a.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount <= 3) {
                    switch (comasCount) {
                        case 0:
                        ret.add(Bonus);
                            Bonus = "Title: ";
                        break;
                        case 1:
                        ret.add(Bonus);
                            Bonus = "Score: ";
                        break;
                        case 2: 
                        ret.add(Bonus);
                            Bonus = "Review: ";
                        break;
                    }
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < a.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;


    }

    @GetMapping("/BookReviews_{bookName}")
    public List<String> BookReviews(@PathVariable String bookName){
        List<String> a = reviewService.BookReviews(bookName);

        List<String> pauta = Arrays.asList("Username", "Title", "Score","Review");

        return Ordenar(a, pauta);

    }

    public List<String> Ordenar(List<String> datos, List<String> pauta){

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < datos.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += pauta.get(comasCount) + ": ";
            
            String b= datos.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount < pauta.size()-1) {
                    ret.add(Bonus);
                    Bonus = pauta.get(comasCount+1)+ ": ";
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < datos.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;

    }

}