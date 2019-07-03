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

        List<Restaurant> restaurantResult = new ArrayList<>();

        List<Restaurant> all = restaurantRepository.getAll();


        for (Restaurant restaurant : all) {

            for (Cuisine cuisine : restaurant.getCuisine()) {

                if (cuisine.toString().equals(cuisineName)) {
                    restaurantResult.add(restaurant);
                }
            }


        }

        return restaurantResult;
    }

    public Set<Restaurant> getByMoreCuisineType(String... cuisineName) {

        Set<Restaurant> restaurantResult = new HashSet<>();

        List<Restaurant> all = restaurantRepository.getAll();

        List<Cuisine> cuisineToCheck = new ArrayList<>();


        for (Restaurant restaurant : all) {
            for (Cuisine cuisine : restaurant.getCuisine()) {
                for (String cuisineType : cuisineName) {
                    if (cuisine.toString().equals(cuisineType)) {
                        restaurantResult.add(restaurant);
                    }
                }

            }
        }


        return restaurantResult;
    }

    public List<Restaurant> getByMealType(String mealName) {

        List<Restaurant> restaurantResult = new ArrayList<>();

        List<Restaurant> all = restaurantRepository.getAll();


        for (Restaurant restaurant : all) {

            for (MealType mealType : restaurant.getMealType()) {

                if (mealType.toString().equals(mealName)) {
                    restaurantResult.add(restaurant);
                }
            }


        }

        return restaurantResult;
    }

    public Set<Restaurant> getByMoreMealTypes(String... mealName) {

        Set<Restaurant> restaurantResult = new HashSet<>();

        List<Restaurant> all = restaurantRepository.getAll();

        List<Cuisine> cuisineToCheck = new ArrayList<>();


        for (Restaurant restaurant : all) {
            for (MealType mealType : restaurant.getMealType()) {
                for (String cuisineType : mealName) {
                    if (mealType.toString().equals(mealName)) {
                        restaurantResult.add(restaurant);
                    }
                }

            }
        }


        return restaurantResult;
    }

    public List<Restaurant> findByName(String name){

       return restaurantRepository.findByName(name);
    }

}
