package com.eatMe.controllers;


import com.eatMe.entities.Meal;
import com.eatMe.services.MealService;
import com.eatMe.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {


    MenuService menuService;


    MealService mealService;



    @Autowired
    public MenuController(MenuService menuService, MealService mealService) {
        this.menuService = menuService;
        this.mealService = mealService;
    }


    @GetMapping("menu-list")
    public String showMenu(Model model){

        model.addAttribute("menu",menuService.getMealList(1L));


        return "menu";
    }
    @PostMapping("search-meal")
    public String showMealsWithIngredient(@ModelAttribute("ingredient") String ingredient, Model model){

        List<Meal> mealByIngredient = mealService.getMealByIngredient(ingredient);
        model.addAttribute("menu",mealByIngredient);
        //model.addAttribute("ingredients",menuService.getAllIngredients(restaurantId));

        return "menu";

    }
}
