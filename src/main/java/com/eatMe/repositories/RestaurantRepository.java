package com.eatMe.repositories;


import com.eatMe.entities.Cuisine;
import com.eatMe.entities.MealType;
import com.eatMe.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RestaurantRepository {

    @Autowired
    EntityManager em;

    public Restaurant getById(Long id){
        return em.find(Restaurant.class, id);
    }

    public Restaurant save(Restaurant restaurant){
        if(restaurant.getId() == null){
            em.persist(restaurant);
        }else {
            em.merge(restaurant);
        }

        return restaurant;
    }

    public void removeById(Long id){
        Restaurant restaurant = getById(id);
        em.remove(restaurant);
    }


    public List<Restaurant> getAll(){
        Query query = em.createQuery("select r from Restaurant r", Restaurant.class);
        return query.getResultList();
    }

    public List<Restaurant>findByName(String restaurantName){

        String query1 = "select r from Restaurant r where r.name = :name ";

        Query query = em.createQuery( query1, Restaurant.class).setParameter("name",restaurantName);

        return query.getResultList();

    }

//SELECT a FROM A a JOIN a.b b WHERE b.name = :name

    public List<Restaurant> getRestaurantByCuisine(String name){

        Query query = em.createQuery("select r from Restaurant r where :cuisineName MEMBER OF r.cuisine")
                .setParameter("cuisineName", Cuisine.valueOf(name));

        return query.getResultList();

    }
    public List<Restaurant> getRestaurantByMealType(String name){

        Query query = em.createQuery("select r from Restaurant r where :mealcategory MEMBER OF r.mealType")
                .setParameter("mealcategory", MealType.valueOf(name));

        return query.getResultList();

    }


}
