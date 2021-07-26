package com.alesjdev.movierating.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "score")
    private int score;

    @Column(name = "opinion")
    private String opinion;


    // Constructors
    public Review() {
    }

    public Review(User user, int movieId, int score) {
        this.user = user;
        this.movieId = movieId;
        this.score = score;
    }

    public Review(User user, int movieId, int score, String opinion) {
        this.user = user;
        this.movieId = movieId;
        this.score = score;
        this.opinion = opinion;
    }


    // Getters and Setters
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
