package com.example.Library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

//`reviews` (`user_id`, `book_id`, `score`, `comment`)
@Entity
@Table(name = "reviews")
public class Review {

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    Long userId;

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Long bookId;

    int score;

    String coment;
}
