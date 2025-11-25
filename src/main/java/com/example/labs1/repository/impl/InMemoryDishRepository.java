package com.example.labs1.repository.impl;

import com.example.labs1.bootstrap.DataHolder;
import com.example.labs1.model.Chef;
import com.example.labs1.model.Dish;
import com.example.labs1.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class InMemoryDishRepository implements DishRepository {
    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(long dishId){
        Long dish = Long.valueOf(dishId);
            return DataHolder.dishes.stream().filter(d-> d.getMyID().equals(dish)).findFirst().get();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return DataHolder.dishes.stream().filter(d-> d.getMyID().equals(id)).findFirst();

    }
    @Override
    public Optional<Dish> findById(String id) {
        return DataHolder.dishes.stream().filter(d-> d.getDishId().equals(id)).findFirst();

    }

    @Override
    public Dish save(Dish dish) {
        DataHolder.dishes.add(dish);
        return dish;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.remove(findByDishId(id));
    }
    @Override
    public void deleteById(String id) {
        DataHolder.dishes.remove(findById(id));
    }
}
