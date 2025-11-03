package com.example.labs1.repository.impl;

import com.example.labs1.bootstrap.DataHolder;
import com.example.labs1.model.Dish;
import com.example.labs1.repository.DishRepository;

import java.util.List;

public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(long dishId){
            return DataHolder.dishes.stream().filter(d-> d.getMyID().equals(dishId)).findFirst().get();
    }
}
