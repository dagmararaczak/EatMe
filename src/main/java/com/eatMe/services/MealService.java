package com.eatMe.services;

import com.eatMe.entities.Ingredients;
import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    MenuService menuService;


    public List<Meal> getMealByIngredient(Long restaurantId, String ingredient){

        List<Meal> mealsWithIngredients = new ArrayList<>();

        Menu menuByRestaurantId = menuService.getMenuByRestaurantId(restaurantId);

        List<Meal> mealList = menuService.getMealList(menuByRestaurantId.getId());

        List<Meal> withIngredientAll = mealRepository.findByIngredient(ingredient);

        for (Meal meal : mealList) {

            if (withIngredientAll.contains(meal)) {

                mealsWithIngredients.add(meal);

            }

        }

        return mealsWithIngredients;


    }


    public List<Meal> getMealWithoutIngredient(Long restaurantId, String ingredient) {

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

    public Set<Meal> choseByIngredients(Long restaurantId, String ingredientWanted, String ingredientsYouDontWanna){

        Set<Meal> resultMeals = new HashSet<>();
        List<Meal> mealWithoutIngredient = getMealWithoutIngredient(restaurantId, ingredientsYouDontWanna);

        List<Meal> mealByIngredient = getMealByIngredient(restaurantId,ingredientWanted);


        if(mealByIngredient.isEmpty()){

            resultMeals.addAll(mealWithoutIngredient);

            return resultMeals;
        }else if(mealWithoutIngredient.isEmpty()){

            resultMeals.addAll(mealByIngredient);

        }else {

            for (Meal meal : mealWithoutIngredient) {

                if (mealByIngredient.contains(meal)){
                    resultMeals.add(meal);
                }
            }
        }



        return resultMeals;


    }


}
