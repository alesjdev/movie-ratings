package com.alesjdev.movierating.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Value("${tmdb.image-path}")
    private String IMAGE_PATH;  // Path prefix to add to the image links

    @JsonProperty("id")
    private int id;

    @JsonProperty("imdb_id")
    private String imdb_id;

    @JsonProperty("budget")
    private int budget;

    @JsonProperty("original_language")
    private String original_language;

    @JsonProperty("title")
    private String title;

    @JsonProperty("original_title")
    private String original_title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("backdrop_path")
    private String backdrop_path;

    @JsonProperty("poster_path")
    private String poster_path;

    @JsonProperty("release_date")
    private String release_date;

    @JsonProperty("revenue")
    private int revenue;

    @JsonProperty("status")
    private String status;  // Rumored, planned, in production, post production, released, canceled

    @JsonProperty("adult")
    private boolean adult;

    private Set<Person> people = new HashSet<>();

    private Set<Genre> genres = new HashSet<>();

    private Set<Review> reviews = new HashSet<>();


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
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

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "IMAGE_PATH='" + IMAGE_PATH + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", budget=" + budget +
                ", original_language='" + original_language + '\'' +
                ", title='" + title + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", status='" + status + '\'' +
                ", adult=" + adult +
                '}';
    }
}
