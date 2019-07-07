package com.eatMe.services;

import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.MenuRepository;
import com.eatMe.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuRepository menuRepository;


    public List<Restaurant> getByCuisineType(String cuisineName) {

        return restaurantRepository.getRestaurantByCuisine(cuisineName);
    }


    public List<Restaurant> findByName(String name) {

        return restaurantRepository.findByName(name);
    }


    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

    public Restaurant getById(Long id) {
        return restaurantRepository.getById(id);
    }


    public Set<Restaurant> getByCuisineAndMeal(List<String> cuisine, List<String> meal) {

        Set<Restaurant> resultRestaurants = new HashSet<>();
        Set<Restaurant> restaurantsByCuisine = new HashSet<>();
        Set<Restaurant> restaurantsByMeal = new HashSet<>();


        if (cuisine.isEmpty()) {


            for (String mealName : meal) {

                List<Restaurant> restaurantByMealType = restaurantRepository.getRestaurantByMealType(mealName);
                restaurantsByMeal.addAll(restaurantByMealType);

            }

            return restaurantsByMeal;

        } else if (meal.isEmpty()) {

            for (String cuisineName : cuisine) {

                List<Restaurant> restaurantByCuisine = restaurantRepository.getRestaurantByCuisine(cuisineName);
                restaurantsByCuisine.addAll(restaurantByCuisine);


            }

            return restaurantsByCuisine;

        } else {

            for (String cuisineName : cuisine) {

                List<Restaurant> restaurantByCuisine = restaurantRepository.getRestaurantByCuisine(cuisineName);
                restaurantsByCuisine.addAll(restaurantByCuisine);


            }

            for (String mealName : meal) {

                List<Restaurant> restaurantByMealType = restaurantRepository.getRestaurantByMealType(mealName);
                restaurantsByMeal.addAll(restaurantByMealType);

            }


            for (Restaurant restaurant : restaurantsByCuisine) {

                if (restaurantsByMeal.contains(restaurant)) {
                    resultRestaurants.add(restaurant);
                }
            }

        }


        return resultRestaurants;

    }



    public Set<Restaurant> getByMaxCost(Double mealCost) {

        Set<Restaurant> restaurantWithMinCost = new HashSet<>();

        List<Restaurant> allRestaurant = restaurantRepository.getAll();

        if(mealCost == null){
            return restaurantWithMinCost;
        }

        for (Restaurant restaurant : allRestaurant) {

            Menu menu = menuRepository.getByRestaurantId(restaurant.getId());

            List<Meal> mealList = menuRepository.getMealList(menu.getId());

            Meal max = Collections.max(mealList, Comparator.comparing(Meal::getPrice));


            if (mealCost >= max.getPrice()) {
                restaurantWithMinCost.add(restaurant);
            }

        }

        return restaurantWithMinCost;

    }




    public Set<Restaurant> getByCriteria(List<String> cuisine, List<String> meal, Double max) {


        Set<Restaurant> byCuisineAndMeal = getByCuisineAndMeal(cuisine, meal);
        Set<Restaurant> byCosts = getByMaxCost(max);
        Set<Restaurant> restaurants = new HashSet<>();

        if (byCuisineAndMeal.isEmpty()) {
            restaurants.addAll(byCosts);

            return restaurants;
        } else if (max == null | byCosts.isEmpty()) {

            restaurants.addAll(byCuisineAndMeal);

            return restaurants;

        } else {

            for (Restaurant restaurant : byCuisineAndMeal) {

                if (byCosts.contains(restaurant)) {

                    restaurants.add(restaurant);
                }
            }


        }

        return restaurants;
    }


}

