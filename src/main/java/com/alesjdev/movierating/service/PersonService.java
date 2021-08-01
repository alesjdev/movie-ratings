package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Person;

import java.util.Set;


public interface PersonService {
    public Person findById(int personId);
    public Set<Person> findByKeyword(String keyword);
    public Set<Person> findPopular();
}
