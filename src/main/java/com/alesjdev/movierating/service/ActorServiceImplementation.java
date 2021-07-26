package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.ActorRepository;
import com.alesjdev.movierating.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImplementation implements ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public void save(Actor theActor) {
        actorRepository.save(theActor);
    }
}
