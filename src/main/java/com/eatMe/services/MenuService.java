package com.eatMe.services;


import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import com.eatMe.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;


    public List<Meal> getMealList(Long id){


       return menuRepository.getMealList(id);


    }
}
