package com.alesjdev.movierating.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "review", schema = "public")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "score")
    private int score;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "date_posted")
    private long datePosted;


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

    public Review(int id, User user, int movieId, int score, String opinion) {
        this.id = id;
        this.user = user;
        this.movieId = movieId;
        this.score = score;
        this.opinion = opinion;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public long getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(long datePosted) {
        this.datePosted = datePosted;
    }

    // Convenience method to get the date and time based on the millis
    public String getDateTime(){
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.datePosted), ZoneId.systemDefault());
        return ldt.toString();
    }
}
