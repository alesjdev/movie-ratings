package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.PersonRepository;
import com.alesjdev.movierating.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void save(Person thePerson) {
        personRepository.save(thePerson);
    }
}
