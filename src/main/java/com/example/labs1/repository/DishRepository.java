package com.example.labs1.repository;

import com.example.labs1.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(long dishId);

}
