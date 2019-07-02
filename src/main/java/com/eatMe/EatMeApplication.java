package com.eatMe;

import com.eatMe.entities.Cuisine;
import com.eatMe.entities.Ingredients;
import com.eatMe.repositories.IngredientsRepository;
import com.eatMe.repositories.RestaurantRepository;
import com.eatMe.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EatMeApplication implements CommandLineRunner {

	@Autowired
	IngredientsRepository ingredientsRepository;

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	RestaurantService restaurantService;

	public static void main(String[] args) {
		SpringApplication.run(EatMeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		restaurantService.getByCuisineType("ITALIAN");

		restaurantService.getByMoreCuisineType("ITALIAN");







	}
}