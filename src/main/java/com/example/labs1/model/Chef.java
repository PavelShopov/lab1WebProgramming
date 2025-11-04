package com.example.labs1.model;

import jakarta.annotation.PostConstruct;
import lombok.*;

import java.util.List;
@Data
public class Chef {
    private String firstName;
    private String lastName;
    private String bio;
    private List<Dish> dishes;
    private Long myID;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static Long id=1L;


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

    }
}
