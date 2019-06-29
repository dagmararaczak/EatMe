package com.eatMe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToMany(mappedBy = "menu")
    List<Meal> mealsList = new ArrayList<>();

    

   // Map<Meal,List<String>> menu;

    private Menu() {
    }

   /* public List<Meal> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<Meal> mealsList) {
        this.mealsList = mealsList;
    }

    public Map<Meal, List<String>> getMenu() {
        return menu;
    }

    public void setMenu(Map<Meal, List<String>> menu) {
        this.menu = menu;
    }*/
}
