package com.alesjdev.movierating.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Movie> movieList = new HashSet<>();

    // Constructors
    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(Set<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Utility methods to add/remove a movie from the genre
    public void addMovie(Movie theMovie){
        this.movieList.add(theMovie);
        theMovie.addGenre(this);
    }
    public void removeMovie(Movie theMovie){
        this.movieList.remove(theMovie);
        theMovie.removeGenre(this);
    }
}
