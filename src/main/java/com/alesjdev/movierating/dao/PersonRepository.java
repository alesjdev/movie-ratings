package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
