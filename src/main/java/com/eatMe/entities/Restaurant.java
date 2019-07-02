package com.eatMe.entities;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;
    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = true)
    private Double maxCost;
    @Column(nullable = true)
    private Double minCost;

    @ElementCollection(targetClass = MealType.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "restaurant_meal", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "meal_type", nullable = true)
    @Enumerated(EnumType.STRING)
   private Set<MealType> mealTypeEnum;

    @ElementCollection(targetClass = Cuisine.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "restaurant_cuisine", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "cuisine", nullable = true)
    private Set<Cuisine> cuisine;

    @OneToOne(fetch = FetchType.EAGER)
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

    public Set<MealType> getMealTypeEnum() {
        return mealTypeEnum;
    }


}
