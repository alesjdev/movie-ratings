package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
