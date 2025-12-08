package com.example.labs1.service.impl;

import com.example.labs1.model.Chef;
import com.example.labs1.repository.ChefRepository;
import com.example.labs1.repository.DishRepository;
import com.example.labs1.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChefServiceImpl implements ChefService  {
    public final ChefRepository chefRepository;
    public final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;

    }
    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chef = this.chefRepository.findById(chefId).get();
        chef.getDishes().add(
                this.dishRepository.findByDishId(Long.parseLong(dishId))
        );
        chefRepository.save(chef);
        return chef;
    }
}

