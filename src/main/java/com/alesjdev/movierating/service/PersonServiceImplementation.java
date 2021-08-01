package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Person;
import com.alesjdev.movierating.model.PersonSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;

@Service
public class PersonServiceImplementation implements PersonService {

    @Value("${tmdb.prefix-path}")
    private String PREFIX_PATH;

    @Value("${tmdb.api-key}")
    private String API_KEY;

    @Override
    public Person findById(int personId) {
        return obtainSinglePerson("/person/" + personId);
    }

    @Override
    public Set<Person> findByKeyword(String keyword) {
        return obtainPeopleByKeyword("/search/person", keyword);
    }

    @Override
    public Set<Person> findPopular() {
        return obtainPeople("/person/popular");
    }

    private Set<Person> obtainPeople(String from) {
        ObjectMapper mapper = new ObjectMapper();
        PersonSearch personSearch = null;
        try {
            personSearch = mapper.readValue(new URL(PREFIX_PATH
                            + from
                            + "?" + API_KEY),
                    PersonSearch.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (personSearch != null) {
            return personSearch.getPeople();
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }

    private Set<Person> obtainPeopleByKeyword(String from, String keyword) {
        ObjectMapper mapper = new ObjectMapper();
        PersonSearch personSearch = null;
        try {
            personSearch = mapper.readValue(new URL(PREFIX_PATH
                            + from
                            + "?" + API_KEY
                            + "&" + "query=" + keyword
                            + "&" + "include_adult=" + false),
                    PersonSearch.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (personSearch != null) {
            return personSearch.getPeople();
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }

    private Person obtainSinglePerson(String from) {
        ObjectMapper mapper = new ObjectMapper();
        Person thePerson = null;
        try {
            thePerson = mapper.readValue(new URL(PREFIX_PATH
                    + from
                    + "?"
                    + API_KEY),
                    Person.class );
            Person asCast = mapper.readValue(new URL(PREFIX_PATH + from + "/movie_credits" + "?" + API_KEY), Person.class );
            thePerson.setMovies(asCast.getMovies());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (thePerson != null) {
            return thePerson;
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }
}
