package com.example.labs1.service.impl;

import com.example.labs1.model.Dish;
import com.example.labs1.repository.DishRepository;
import com.example.labs1.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishServiceImpl implements DishService {
    public final DishRepository dishRepository;
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(Long.parseLong(dishId));
    }

}
