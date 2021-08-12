package com.alesjdev.movierating.model;

import com.alesjdev.movierating.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private final String IMAGE_PATH_ORIGINAL = "https://image.tmdb.org/t/p/original";
    private final String IMAGE_PATH_W300 = "https://image.tmdb.org/t/p/w300";

    @JsonProperty("id")
    private int id;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("budget")
    private String budget;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("title")
    private String title;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("revenue")
    private String revenue;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("runtime")
    private int runtime;

    @JsonProperty("status")
    private String status;  // Rumored, planned, in production, post production, released, canceled

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("cast")
    private Set<Person> cast = new HashSet<>();

    @JsonProperty("character")
    private String character;

    @JsonProperty("genres")
    private Set<Genre> genres = new HashSet<>();

    // Images
    @JsonProperty("backdrops")
    Set<Image> backdrops = new HashSet<>();

    @JsonProperty("posters")
    Set<Image> posters = new HashSet<>();

    private Set<Review> reviews = new HashSet<>();


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return "https://www.imdb.com/title/" + imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget > 0 ? "$ " + budget : "Not available";
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue > 0 ? "$ " + revenue : "Not available";
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage.toUpperCase();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdropPath() {
        return backdropPath != null ? IMAGE_PATH_ORIGINAL + backdropPath : getPosterPath();
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath != null ? IMAGE_PATH_ORIGINAL + posterPath : null;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterSmall() {
        return posterPath != null ? IMAGE_PATH_W300 + posterPath : null;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Set<Person> getCast() {
        return cast;
    }

    public void setCast(Set<Person> cast) {
        this.cast = cast;
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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Set<Image> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(Set<Image> backdrops) {
        this.backdrops = backdrops;
    }

    public Set<Image> getPosters() {
        return posters;
    }

    public void setPosters(Set<Image> posters) {
        this.posters = posters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", budget='" + budget + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", tagline='" + tagline + '\'' +
                ", overview='" + overview + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", revenue='" + revenue + '\'' +
                ", popularity=" + popularity +
                ", runtime=" + runtime +
                ", status='" + status + '\'' +
                ", adult=" + adult +
                ", genres=" + genres +
                '}';
    }
}
