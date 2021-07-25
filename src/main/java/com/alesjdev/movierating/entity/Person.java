package com.alesjdev.movierating.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pic_link")
    private String picLink;

    @Column(name = "bio")
    private String biography;

    @ManyToMany(mappedBy = "cast", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Movie> movieList = new HashSet<>();


    // Constructors
    public Person() {
    }

    public Person(String name, String picLink, String biography) {
        this.name = name;
        this.picLink = picLink;
        this.biography = biography;
    }

    public Person(int id, String name, String picLink, String biography) {
        this.id = id;
        this.name = name;
        this.picLink = picLink;
        this.biography = biography;
    }

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

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(Set<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picLink='" + picLink + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }

    // Utility methods to add/remove movies from the cast member
    public void addMovie(Movie theMovie){
        this.movieList.add(theMovie);
        theMovie.getCast().add(this);
    }
    public void removeMovie(Movie theMovie){
        this.movieList.remove(theMovie);
        theMovie.getCast().remove(this);
    }
}
