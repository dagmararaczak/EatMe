package com.eatMe.controllers;


import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.RestaurantRepository;
import com.eatMe.services.RestaurantService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class RestaurantController {

    @Autowired
    private ApplicationContext context;

  RestaurantRepository restaurantRepository;

  RestaurantService restaurantService;

  @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository, RestaurantService restaurantService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }



    @GetMapping("welcome")

    public String Welcome(){

        return "welcome";
    }

    @GetMapping("allRestaurants")

    public String allRestaurants(Model model){

        List<Restaurant> allRestaurants = restaurantRepository.getAll();

        model.addAttribute("restaurants",allRestaurants);


        return "allRestaurants";
    }

    @GetMapping("search-restaurant")
    public String searchRestaurant(){

        return "searchRestaurant";
    }



    @PostMapping("search-restaurant")
    public String search(@ModelAttribute("queryString") QueryString queryString, Model model){

        List<Restaurant> byCuisineType = restaurantService.getByCuisineType(queryString.getCuisine());

        model.addAttribute("restaurants",byCuisineType);


        return "allRestaurants";
    }




    @GetMapping("restaurant-profile")
    public String getRestaurant(@RequestParam("id") String id,Model model){

        Long restaurantId = Long.parseLong(id);

        Restaurant restaurant = restaurantRepository.getById(restaurantId);

        model.addAttribute("restaurant",restaurant);



        return "restaurant-profile";
    }


    public static class QueryString{

        String queryString;

        String cuisine;
        String meal;

        public String getMeal() {
            return meal;
        }

        public void setMeal(String meal) {
            this.meal = meal;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public QueryString() {
        }

        public String getQueryString() {
            return queryString;
        }

        public void setQueryString(String queryString) {
            this.queryString = queryString;
        }
    }


}
