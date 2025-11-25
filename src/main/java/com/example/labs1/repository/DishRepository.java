package com.example.labs1.repository;

import com.example.labs1.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(long dishId);
    Optional<Dish> findById(Long id);
    Dish save(Dish dish);
    void deleteById(Long id);
    public Optional<Dish> findById(String id);
    public void deleteById(String id);
}
