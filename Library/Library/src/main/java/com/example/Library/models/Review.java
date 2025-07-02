package com.example.Library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Necesitas un ID para JPA, aunque no sea clave compuesta
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Long userId;

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Long bookId;

    private int score;

    private String comment;

    // Constructor vacío obligatorio para JPA
    public Review() {}

    public Review(Long userId, Long bookId, int score, String comment) {
        this.userId = userId;
        this.bookId = bookId;
        this.score = score;
        this.comment = comment;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    // No setter para id, porque es autogenerado

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}