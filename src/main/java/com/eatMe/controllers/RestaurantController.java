package com.eatMe.controllers;


import com.eatMe.entities.Restaurant;
import com.eatMe.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class RestaurantController {


  RestaurantRepository restaurantRepository;

  @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
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

}
