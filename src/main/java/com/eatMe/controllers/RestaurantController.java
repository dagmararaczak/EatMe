package com.eatMe.controllers;


import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.RestaurantRepository;
import com.eatMe.services.RestaurantService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestaurantController {


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
        List<Restaurant> byCuisineType = restaurantService.getByCuisineType(queryString.getQueryString());

        model.addAttribute("restaurantbycuisine",byCuisineType);



        return "allRestaurants";
    }

  /*  @PostMapping("/searchUserAction")
    public String searchUserByName(@ModelAttribute("queryString") QueryString queryString,Model model){
        List<UserDTO>foundUsers =  userService.findByQueryString(queryString.getQueryString());
        model.addAttribute("allStudents", foundUsers);
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("queryString",new QueryString());

        return "allUsersPage";*/


    public static class QueryString{

        String queryString;

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