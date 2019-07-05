package com.eatMe.services;

import com.eatMe.entities.Ingredients;
import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    MenuService menuService;

    public List<Meal> getMealByIngredient(String ingredient){


        return mealRepository.findByIngredient(ingredient);


    }

    public List<Meal> getMealWithoutIngredient(String ingredient){


        return mealRepository.findWithoutIngredient(ingredient);


    }

    public List<Meal> getMealWithoutIngredient1(Long restaurantId, String ingredient) {

        List<Meal> mealsWithoutIngredients = new ArrayList<>();

        Menu menuByRestaurantId = menuService.getMenuByRestaurantId(restaurantId);

        List<Meal> mealList = menuService.getMealList(menuByRestaurantId.getId());

        List<Meal> withoutIngredientAll = mealRepository.findWithoutIngredient(ingredient);

        for (Meal meal : mealList) {

            if (withoutIngredientAll.contains(meal)) {

                mealsWithoutIngredients.add(meal);

            }

        }

        return mealsWithoutIngredients;


    }


}
