package com.eatMe.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingriedients {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Meal meal;

    public Ingriedients() {
    }
}
