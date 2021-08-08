package com.alesjdev.movierating.entity;

import com.alesjdev.movierating.model.Movie;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "review", schema = "public")
public class Review implements Comparable<Review>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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

    @Transient
    private Movie movie;


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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // Convenience method to get the date and time based on the millis
    public String getDateTime(){
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.datePosted), ZoneId.systemDefault());
        String dateOnly = ldt.toString().substring(0, 10);
        String timeOnly = ldt.toString().substring(11, ldt.toString().length()-4);
        return dateOnly + " at " + timeOnly;
    }


    @Override
    public int compareTo(Review anotherReview) {
        return Long.compare(anotherReview.datePosted, this.datePosted);
    }
}
