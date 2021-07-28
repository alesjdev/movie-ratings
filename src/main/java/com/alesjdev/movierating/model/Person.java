package com.alesjdev.movierating.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Person {

    private int id;

    private String name;

    private List<String> also_known_as;

    private String known_for_department;

    private String birthday;

    private String deathday;

    private int gender;

    private String biography;

    private String place_of_birth;

    private String imdb_id;

    private Set<Movie> movies = new HashSet<>();

    private List<Profile> profiles;  // List of images


    // Constructors
    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, List<String> also_known_as, String known_for_department, String birthday, String deathday, int gender, String biography, String place_of_birth, String imdb_id, Set<Movie> movies, List<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.also_known_as = also_known_as;
        this.known_for_department = known_for_department;
        this.birthday = birthday;
        this.deathday = deathday;
        this.gender = gender;
        this.biography = biography;
        this.place_of_birth = place_of_birth;
        this.imdb_id = imdb_id;
        this.movies = movies;
        this.profiles = profiles;
    }


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

    public List<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(List<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}

