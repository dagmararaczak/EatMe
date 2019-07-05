package com.eatMe.services;


import com.eatMe.entities.Cuisine;
import com.eatMe.entities.MealType;
import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;


    public List<Restaurant> getByCuisineType(String cuisineName) {

        return restaurantRepository.getRestaurantByCuisine(cuisineName);
    }


    public List<Restaurant> findByName(String name){

       return restaurantRepository.findByName(name);
    }


    public List<Restaurant> getAll(){
        return restaurantRepository.getAll();
    }

    public Restaurant getById(Long id){
        return restaurantRepository.getById(id);
    }


    public Set<Restaurant> getByCuisineAndMeal(List<String> cuisine,List<String> meal){

        Set<Restaurant> resultRestaurants = new HashSet<>();
        Set<Restaurant> restaurantsByCuisine = new HashSet<>();
        Set<Restaurant> restaurantsByMeal = new HashSet<>();

        for (String cuisineName : cuisine) {

            List<Restaurant> restaurantByCuisine = restaurantRepository.getRestaurantByCuisine(cuisineName);
            restaurantsByCuisine.addAll(restaurantByCuisine);


        }

        for (String mealName : meal) {

            List<Restaurant> restaurantByMealType = restaurantRepository.getRestaurantByMealType(mealName);
            restaurantsByMeal.addAll(restaurantByMealType);

        }

        resultRestaurants.addAll(restaurantsByCuisine);
        resultRestaurants.addAll(restaurantsByMeal);

        return resultRestaurants;

    }


}

