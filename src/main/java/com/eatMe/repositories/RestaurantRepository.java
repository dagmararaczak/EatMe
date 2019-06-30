package com.eatMe.repositories;


import com.eatMe.entities.Cuisine;
import com.eatMe.entities.Meal;
import com.eatMe.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public Restaurant findByName(String name){

        Query query = em.createQuery("select r from Restaurant r where name = " + name, Restaurant.class);

        return (Restaurant) query.getResultList().get(0);

    }

    public List<Restaurant> findByCusine(Cuisine cuisine){

        Query query = em.createQuery("select c from restaurant_Cuisine c join restaurant r where r.id = c.restaurant_id", Cuisine.class); //??

            return query.getResultList();
    }
}
