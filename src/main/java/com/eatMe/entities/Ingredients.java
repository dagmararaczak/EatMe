package com.eatMe.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredients {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Meal meal;

    public Ingredients() {
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
