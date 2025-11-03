package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;

import java.util.List;

public class ChefServiceImpl implements ChefService  {
    public final ChefRepository chefRepository;
    public final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }
//Методот addDishToChef треба да го најде готвачот по chefId, да го најде јадењето по dishId, да го додаде јадењето во листата на јадења на готвачот, и потоа да го зачува готвачот преку save методот.
//
//DishService треба да зависи од DishRepository
    @Override
    public List<Chef> listChefs() {
        return List.of();
    }

    @Override
    public Chef findById(Long id) {
        return null;
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

