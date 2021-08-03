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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", movieId=" + movieId +
                ", score=" + score +
                ", opinion='" + opinion + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }
}
