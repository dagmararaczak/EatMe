package com.eatMe.services;

import com.eatMe.entities.Ingredients;
import com.eatMe.entities.Meal;
import com.eatMe.repositories.MealRepository;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    MealRepository mealRepository;

    public Meal getMealByIngredient(Long id, Ingredients ingredient){

        Meal meal = mealRepository.getById(id);

        if(meal.getIngredients().contains(ingredient)){

            return meal;

        }


        return null;
    }
}
