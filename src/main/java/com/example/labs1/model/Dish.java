package com.example.labs1.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="dishes")
public class Dish {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static Long id = Long.valueOf(1);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myID;

    String name;
    String cuisine;
    String dishId;
    int preparationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

    private int likeCount;
    public void addLike(){
        likeCount++;
    }

    public Dish(String name, String cuisine, int preparationTime, Chef chef) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.myID = id++;
        this.dishId = String.valueOf(id);
        this.chef = chef;
    }
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
