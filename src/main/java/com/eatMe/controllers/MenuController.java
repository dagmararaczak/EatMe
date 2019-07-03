package com.eatMe.controllers;


import com.eatMe.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {


    MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("menu")
    public String showMenu(Model model){

        model.addAttribute("menu",menuService.getMealList(1L));


        return "menu";
    }
}
