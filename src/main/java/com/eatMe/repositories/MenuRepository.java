package com.eatMe.repositories;


import com.eatMe.entities.Meal;
import com.eatMe.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MenuRepository {

    @Autowired
    EntityManager em;

    public Menu getById(Long id){
        return em.find(Menu.class,id);
    }

    public Menu save(Menu menu){
        if(menu.getId() == null){
            em.persist(menu);
        }else{
            em.merge(menu);
        }

        return menu;
    }

    public void removeById(Long id){

        Menu menu = getById(id);
        em.remove(menu);
    }

    public List<Meal> getMealList(Long menuId){

        String queryString = "select m from Meal m join m.menu me where me.id = :menuId ";

        Query query = em.createQuery(queryString, Meal.class)
                .setParameter("menuId", menuId);

        return query.getResultList();
    }


    public Menu getByRestaurantId(Long restaurantId){
        String queryString ="select m from Menu m join m.restaurant r where r.id =:id";

        Query query = em.createQuery(queryString)
                .setParameter("id",restaurantId);

        return (Menu) query.getResultList().get(0);
    }

}
