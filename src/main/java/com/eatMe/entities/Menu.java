package com.eatMe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Menu {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToMany(mappedBy = "menu")
    List<Meal> mealsList = new ArrayList<>();



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
