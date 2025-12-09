package com.example.labs1.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "chefs")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myID;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)

    private static Long id=1L;
    private String firstName;
    private String lastName;
    private String bio;
    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dish> dishes;

    public Chef() {

    }

    public void AddDish(Dish dish){
        dishes.add(dish);
    }
    @Override
    public String toString() {
        return "Name: " + this.getFirstName()+ ", LastName: " + this.getLastName()+", Bio: " + this.getBio();
    }

    public Chef(String firstName, String lastName, String bio, List<Dish> dishes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
        this.myID = id++;
        this.dishes= new ArrayList<Dish>();
    }
}
