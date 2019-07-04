package com.eatMe.controllers;


import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.RestaurantRepository;
import com.eatMe.services.MenuService;
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

  RestaurantService restaurantService;

  MenuService menuService;

  @Autowired
    public RestaurantController(RestaurantService restaurantService, MenuService menuService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
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


        List <Restaurant> byCuisineType = restaurantService.getByCuisineType(queryString.cuisine);

        model.addAttribute("restaurants",byCuisineType);


        return "allRestaurants";
    }




    @GetMapping("restaurant-profile")
    public String getRestaurant(@RequestParam("id") String id,Model model){

        Long restaurantId = Long.parseLong(id);

        Restaurant restaurant = restaurantService.getById(restaurantId);
        Menu menuByRestaurantId = menuService.getMenuByRestaurantId(restaurantId);
        List<Meal> mealList = menuService.getMealList(menuByRestaurantId.getId());

        model.addAttribute("restaurant",restaurant);
        model.addAttribute("menu",mealList);



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
