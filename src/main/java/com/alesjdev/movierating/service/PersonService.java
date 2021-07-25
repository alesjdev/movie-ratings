package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public void save(Person thePerson);
}
