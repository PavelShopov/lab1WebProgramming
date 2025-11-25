package com.example.labs1.model;

import jakarta.annotation.PostConstruct;
import lombok.*;

@Data
public class Dish {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static Long id= Long.valueOf(1);
    private Long myID;
    String name;
    String cuisine;
    String dishId;
    int preparationTime;

    public Dish(String name, String cuisine, int preparationTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.myID = id++;
        this.dishId = String.valueOf(id);
    }
    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.myID = id++;
        this.dishId = dishId;

    }

    public Dish() {

    }
}
