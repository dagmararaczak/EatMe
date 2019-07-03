package com.eatMe.entities;


import javax.persistence.*;

@Entity
public class Ingredients {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    Meal meal;

    public Ingredients() {
    }

    public Ingredients(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
