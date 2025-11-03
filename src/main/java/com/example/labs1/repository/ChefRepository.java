package com.example.labs1.repository;

import com.example.labs1.model.Chef;

import java.util.*;

public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
}
