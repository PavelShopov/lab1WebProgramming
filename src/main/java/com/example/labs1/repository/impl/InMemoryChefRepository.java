package com.example.labs1.repository.impl;

import com.example.labs1.bootstrap.DataHolder;
import com.example.labs1.model.Chef;
import com.example.labs1.repository.ChefRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class InMemoryChefRepository implements ChefRepository {
    @Override
    public List<Chef> findAll() {
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return DataHolder.chefs.stream().filter(c-> c.getMyID().equals(id)).findFirst();
    }

    @Override
    public Chef save(Chef chef) {
        if (DataHolder.chefs.removeIf(c-> c.getFirstName().equals(chef.getFirstName()) && c.getLastName().equals(chef.getLastName())))
            DataHolder.chefs.add(chef);
        return chef;
    }

}
