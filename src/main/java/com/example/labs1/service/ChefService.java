package com.example.labs1.service;

import com.example.labs1.model.Chef;

import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
}