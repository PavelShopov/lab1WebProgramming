package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.repository.ChefRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

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
