package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Actor;

import java.util.List;

public interface ActorService {
    public List<Actor> findAll();
    public void save(Actor theActor);
}
