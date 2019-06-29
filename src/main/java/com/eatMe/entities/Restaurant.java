package com.eatMe.entities;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long  Id;

    private String name;

    private Double maxCost;

    private Double minCost;

    @ElementCollection(targetClass = MealType.class)
    @Enumerated(EnumType.STRING)
   private Set<MealType> mealType;

    @ElementCollection(targetClass = Cuisine.class)
    @Enumerated(EnumType.STRING)
    private Set<Cuisine> cuisine;

    @OneToOne
    private Menu menu;


    private Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
