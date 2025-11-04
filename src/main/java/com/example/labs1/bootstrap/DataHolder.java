package com.example.labs1.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import com.example.labs1.model.Chef;
import com.example.labs1.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Component
public class DataHolder {
    @Setter(AccessLevel.NONE)
    public static List<Chef> chefs ;
    @Setter(AccessLevel.NONE)
    public static List<Dish> dishes;

    @PostConstruct
    void init(){
        chefs = new ArrayList<>();
        dishes = new ArrayList<>();
        Dish dish1 = new Dish("Margherita Pizza", "Italian", 20);
        Dish dish2 = new Dish("Beef Tacos", "Mexican", 35);
        Dish dish3 = new Dish("Pad Thai", "Thai", 25);
        Dish dish4 = new Dish("Sushi Rolls (Nigiri)", "Japanese", 40);
        Dish dish5 = new Dish("French Onion Soup", "French", 60);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);
        chefs.add(new Chef(
                        "Giacomo",
                        "Rossi",
                        "A master of traditional Neapolitan cuisine with a passion for simple, fresh ingredients.",
                        Arrays.asList(dish1,dish2) // Margherita Pizza, French Onion Soup
                ));
        chefs.add(
                new Chef(
                        "Elena",
                        "Ramirez",
                        "Known for her vibrant, authentic Mexican street food and innovative spice blends.",
                        Arrays.asList(dish2, dish1) // Beef Tacos, Margherita Pizza
                ));
        chefs.add(
                new Chef(
                        "Somsak",
                        "Panya",
                        "Specializes in balancing the sweet, sour, salty, and spicy flavors of classic Thai cooking.",
                        Arrays.asList(dish3, dish4) // Pad Thai, Sushi Rolls
                ));
        chefs.add(
                new Chef(
                        "Hiroshi",
                        "Tanaka",
                        "A disciplined sushi master, dedicated to the art of precise cutting and perfect rice seasoning.",
                        Arrays.asList(dish4, dish3) // Sushi Rolls, Pad Thai
                ));
        chefs.add(
                new Chef(
                        "Jean-Pierre",
                        "Dubois",
                        "An acclaimed Parisian chef focused on timeless French techniques and rich sauces.",
                        Arrays.asList(dish5, dish2)

                )
                );

    }

}
