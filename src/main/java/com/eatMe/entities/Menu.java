package com.eatMe.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy = "menu")
    List<Meal> mealsList = new ArrayList<>();

    @OneToOne
    Restaurant restaurant;


    private Menu() {
    }

    public Long getId() {
        return Id;
    }

    public List<Meal> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<Meal> mealsList) {
        this.mealsList = mealsList;
    }
}
