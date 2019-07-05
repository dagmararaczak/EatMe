package com.eatMe.services;


import com.eatMe.entities.Ingredients;
import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.repositories.MealRepository;
import com.eatMe.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuService {


    MenuRepository menuRepository;

    MealRepository mealRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, MealRepository mealRepository) {
        this.menuRepository = menuRepository;
        this.mealRepository = mealRepository;
    }

    public List<Meal> getMealList(Long id){


       return menuRepository.getMealList(id);


    }

    public Menu getMenuByRestaurantId(Long id){
        return menuRepository.getByRestaurantId(id);
    }

    public Set<Ingredients> getAllIngredients(Long restaurantId){

        Set<Ingredients> result = new HashSet<>();

        Menu menuByRestaurantId = getMenuByRestaurantId(restaurantId);

        List<Meal> mealList = menuRepository.getMealList(menuByRestaurantId.getId());
        for (Meal meal : mealList) {

            List<Ingredients> allIngredients = mealRepository.getAll(meal.getId());

            result.addAll(allIngredients);

        }

        return result;
    }
}
