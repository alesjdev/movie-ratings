package com.alesjdev.movierating.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private final String IMAGE_PATH_ORIGINAL = "https://image.tmdb.org/t/p/original";
    private final String IMAGE_PATH_W300 = "https://image.tmdb.org/t/p/w300";

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("known_for_department")
    private String knownForDepartment;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("profile_path")
    private String profilePath;

    @JsonProperty("character")
    private String character;

    @JsonProperty("also_known_as")
    private List<String> alsoKnownAs;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("deathday")
    private String deathday;

    @JsonProperty("biography")
    private String biography;

    @JsonProperty("place_of_birth")
    private String placeOfBirth;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("cast")
    private Set<Movie> movies = new HashSet<>();

    private List<Image> images;  // List of images


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getProfilePath() {
        return profilePath != null ?
                IMAGE_PATH_ORIGINAL + profilePath : null;
    }

    public String getProfileSmall() {
        return profilePath != null ?
                IMAGE_PATH_W300 + profilePath : null;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> aka) {
        alsoKnownAs = aka.stream()
                // Filter all non latin characters that could cause display errors
                .filter(s -> s.matches("^[\\p{Print}\\p{IsLatin}]*$"))
                .collect(Collectors.toList());
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getImdbId() {
        return "https://www.imdb.com/name/" + imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public List<Image> getProfiles() {
        return images;
    }

    public void setProfiles(List<Image> images) {
        this.images = images;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", adult=" + adult +
                ", knownForDepartment='" + knownForDepartment + '\'' +
                ", popularity=" + popularity +
                ", profilePath='" + profilePath + '\'' +
                ", character='" + character + '\'' +
                ", alsoKnownAs=" + alsoKnownAs +
                ", birthday='" + birthday + '\'' +
                ", deathday='" + deathday + '\'' +
                ", biography='" + biography + '\'' +
                ", place_of_birth='" + placeOfBirth + '\'' +
                ", imdb_id='" + imdbId + '\'' +
                '}';
    }
}

