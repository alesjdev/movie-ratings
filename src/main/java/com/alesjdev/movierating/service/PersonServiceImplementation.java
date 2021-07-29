package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

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

    private Person obtainSinglePerson(String from) {
        ObjectMapper mapper = new ObjectMapper();
        Person thePerson = null;
        try {
            thePerson = mapper.readValue(new URL(PREFIX_PATH + from + "?" + API_KEY), Person.class );
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
