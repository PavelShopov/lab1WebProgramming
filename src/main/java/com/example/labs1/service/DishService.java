package com.example.labs1.service;

import com.example.labs1.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
    Dish findByDishId(Long dishId);
    Dish create(String dishId, String name, String cuisine, int preparationTime);
    Dish update( String dishId, String name, String cuisine, int preparationTime);
    void delete(Long id);
}