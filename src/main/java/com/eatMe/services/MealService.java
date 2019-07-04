package com.eatMe.services;

import com.eatMe.entities.Ingredients;
import com.eatMe.entities.Meal;
import com.eatMe.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public List<Meal> getMealByIngredient(String ingredient){


        return mealRepository.findByIngredient(ingredient);


    }


}
