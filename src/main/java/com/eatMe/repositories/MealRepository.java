package com.eatMe.repositories;
import com.eatMe.entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MealRepository {

    @Autowired
    EntityManager em;

    public Meal getById(Long id){

        return em.find(Meal.class, id);
    }

    public Meal save(Meal meal){
        if(meal.getId() == null){
            em.persist(meal);
        }else {
            em.merge(meal);
        }

        return meal;
    }


    public void removeById(Long id){
        Meal byId = getById(id);
        em.remove(byId);

    }


    public List<Meal> getAll(){
        Query query = em.createQuery("select m from Meal m", Meal.class);
        return query.getResultList();
    }

    public Meal findByName(String name){

        Query query = em.createQuery("select m from Meal m where name =:name", Meal.class)
                .setParameter("name",name);

        return (Meal) query.getResultList().get(0);

    }

    public List<Meal> findByIngredient(String ingredient){

        Query query = em.createQuery("select m from Meal m join m.ingredients i where i.name =:ingredient", Meal.class)
                .setParameter("ingredient",ingredient);



        return (List<Meal>)query.getResultList();

    }

    public List<Meal> findByIngredientAndRestaurant(String ingredient){

        Query query = em.createQuery("select m from Meal m join m.ingredients i where i.name =:ingredient", Meal.class)
                .setParameter("ingredient",ingredient);

        return query.getResultList();

    }

    public List<Meal> findWithoutIngredient(String ingredient){

        Query query = em.createQuery("select m from Meal m join m.ingredients i where i.name !=:ingredient", Meal.class)
                .setParameter("ingredient",ingredient);

        return query.getResultList();

    }


}

