package com.example.labs1.service;

import com.example.labs1.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}