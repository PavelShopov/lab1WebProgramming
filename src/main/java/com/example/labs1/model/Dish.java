package com.example.labs1.model;

import jakarta.annotation.PostConstruct;
import lombok.*;

@Data
public class Dish {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static Long id=1L;
    private Long myID;
    String name;
    String cuisine;
    int preparationTime;
    public Dish(String name, String cuisine, int preparationTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.myID = id++;
    }
}
