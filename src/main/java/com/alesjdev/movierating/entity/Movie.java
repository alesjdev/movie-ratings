package com.alesjdev.movierating.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "plot")
    private String plot;

    @Column(name = "trailer_link")
    private String trailer_link;

    @Column(name = "poster_link")
    private String poster_link;

    @Column(name = "year")
    private int year;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> cast = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviewList = new HashSet<>();


    // Constructors
    public Movie() {}

    public Movie(String title, String plot, String trailer_link, String poster_link, int year) {
        this.title = title;
        this.plot = plot;
        this.trailer_link = trailer_link;
        this.poster_link = poster_link;
        this.year = year;
    }

    public Movie(int id, String title, String plot, String trailer_link, String poster_link, int year) {
        this.id = id;
        this.title = title;
        this.plot = plot;
        this.trailer_link = trailer_link;
        this.poster_link = poster_link;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getTrailer_link() {
        return trailer_link;
    }

    public void setTrailer_link(String trailer_link) {
        this.trailer_link = trailer_link;
    }

    public String getPoster_link() {
        return poster_link;
    }

    public void setPoster_link(String poster_link) {
        this.poster_link = poster_link;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(Set<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", trailer_link='" + trailer_link + '\'' +
                ", poster_link='" + poster_link + '\'' +
                ", year=" + year +
                '}';
    }

    // Utility method to add/remove cast from the movie
    public void addCast(Actor theActor){
        cast.add(theActor);
        theActor.getMovieList().add(this);
    }
    public void removeCast(Actor theActor) {
        cast.remove(theActor);
        theActor.getMovieList().remove(this);
    }

    // Utility method to add/remove genres from the movie
    public void addGenre(Genre theGenre){
        genres.add(theGenre);
        theGenre.getMovieList().add(this);
    }
    public void removeGenre(Genre theGenre) {
        genres.remove(theGenre);
        theGenre.getMovieList().remove(this);
    }

    // Utility method to add/remove reviews from the movie
    public void addReview(Review theReview){
        reviewList.add(theReview);
        theReview.setMovie(this);
    }
    public void removeReview(Review theReview) {
        reviewList.remove(theReview);
        theReview.setMovie(null);
    }
}
