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

    @OneToOne(fetch = FetchType.LAZY)
    private Menu menu;


    private Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return Id;
    }

    public Double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Double maxCost) {
        this.maxCost = maxCost;
    }

    public Double getMinCost() {
        return minCost;
    }

    public void setMinCost(Double minCost) {
        this.minCost = minCost;
    }

    public Set<MealType> getMealType() {
        return mealType;
    }

    public void setMealType(Set<MealType> mealType) {
        this.mealType = mealType;
    }

    public Set<Cuisine> getCuisine() {
        return cuisine;
    }

    public void setCuisine(Set<Cuisine> cuisine) {
        this.cuisine = cuisine;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
