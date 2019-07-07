package com.eatMe.controllers;


import com.eatMe.entities.*;
import com.eatMe.repositories.AdresRepository;
import com.eatMe.repositories.RestaurantRepository;
import com.eatMe.services.AdresService;
import com.eatMe.services.MenuService;
import com.eatMe.services.RestaurantService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class RestaurantController {

  RestaurantService restaurantService;

  MenuService menuService;

  AdresService adresService;

  @Autowired
    public RestaurantController(RestaurantService restaurantService, MenuService menuService, AdresService adresService ) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
        this.adresService = adresService;
    }

    @GetMapping("welcome")

    public String Welcome(){

        return "welcome";
    }

    @GetMapping("all-Restaurants")

    public String allRestaurants(Model model){

        List<Restaurant> allRestaurants = restaurantService.getAll();

        model.addAttribute("restaurants",allRestaurants);


        return "allRestaurants";
    }

    @GetMapping("search-restaurant")
    public String searchRestaurant(Model model){
      model.addAttribute("queryString",new QueryString());

        return "searchRestaurant";
    }



    @PostMapping("search-restaurant")
    public String search(@ModelAttribute("queryString") QueryString queryString, Model model){

        Set<Restaurant> restaurants = restaurantService.getByCuisineAndMeal(queryString.cuisinelist, queryString.meallist);

       model.addAttribute("restaurants",restaurants);


        return "allRestaurants";
    }




    @GetMapping("restaurant-profile")
    public String getRestaurant(@RequestParam("id") String id,Model model){

        Long restaurantId = Long.parseLong(id);

        Restaurant restaurant = restaurantService.getById(restaurantId);
        Menu menuByRestaurantId = menuService.getMenuByRestaurantId(restaurantId);
        List<Meal> mealList = menuService.getMealList(menuByRestaurantId.getId());
        Adres adres = adresService.getByRestaurantId(restaurantId);

        model.addAttribute("restaurant",restaurant);
        model.addAttribute("menu",mealList);
        model.addAttribute("adres",adres);




        return "restaurant-profile";
    }


    public static class QueryString{

        String queryString;

        String cuisine;

        String meal;

        Double min;

        Double max;

        public Double getMin() {
            return min;
        }

        public void setMin(Double min) {
            this.min = min;
        }

        public Double getMax() {
            return max;
        }

        public void setMax(Double max) {
            this.max = max;
        }

        List<String> cuisinelist = new ArrayList<>();
        List<String> meallist = new ArrayList<>();

        public List<String> getCuisinelist() {
            return cuisinelist;
        }

        public void setCuisinelist(List<String> cuisinelist) {
            this.cuisinelist = cuisinelist;
        }

        public List<String> getMeallist() {
            return meallist;
        }

        public void setMeallist(List<String> meallist) {
            this.meallist = meallist;
        }

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
