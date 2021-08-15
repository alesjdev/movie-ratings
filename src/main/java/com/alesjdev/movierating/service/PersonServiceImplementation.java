package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.model.MovieSearch;
import com.alesjdev.movierating.model.Person;
import com.alesjdev.movierating.model.PersonSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImplementation implements PersonService {

    // Variable to set how many results to show (20 results per page queried)
    private int PAGES_TO_QUERY = 5;

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
        // Create set to hold results from all pages queried
        Set<Person> results = new HashSet<>();

        // Create JSON's object mapper
        ObjectMapper mapper = new ObjectMapper();

        // Create new object to hold search results
        PersonSearch personSearch = null;
        try {
            // Add 20 results to the search for every page queried
            for (int page = 1; page <= PAGES_TO_QUERY; page++) {
                personSearch = mapper.readValue(new URL(PREFIX_PATH
                                + from
                                + "?" + API_KEY
                                + "&" + "page=" + page),
                        PersonSearch.class);
                results.addAll(personSearch.getPeople());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Throw runtime exception if there was a problem fetching the data
        if (results.isEmpty()) {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
        return results;
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
