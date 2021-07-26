package com.alesjdev.movierating.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.Set;


public class Movie {

    @Value("image_path")
    private String IMAGE_PATH;  // Path prefix to add to the image links

    private int id;

    private int imdb_id;

    private int budget;

    private String original_language;

    private String title;

    private String original_title;

    private String overview;

    private String backdrop_path;

    private String poster_path;

    private String release_date;

    private int revenue;

    private String status;  // Rumored, planned, in production, post production, released, canceled

    private Set<Person> people = new HashSet<>();

    private Set<Genre> genres = new HashSet<>();

    private Set<Review> reviews = new HashSet<>();


    // Constructors
    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie(int id, int imdb_id, int budget, String original_language, String title, String original_title, String overview, String backdrop_path, String poster_path, String release_date, int revenue, String status, Set<Person> people, Set<Genre> genres, Set<Review> reviews) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.budget = budget;
        this.original_language = original_language;
        this.title = title;
        this.original_title = original_title;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.revenue = revenue;
        this.status = status;
        this.people = people;
        this.genres = genres;
        this.reviews = reviews;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(int imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = IMAGE_PATH + backdrop_path;  // Add path prefix to the image link
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = IMAGE_PATH + poster_path;  // Add path prefix to the image link
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
