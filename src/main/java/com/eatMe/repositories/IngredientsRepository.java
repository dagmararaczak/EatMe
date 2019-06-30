package com.eatMe.repositories;

import com.eatMe.entities.Ingredients;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;

import java.util.List;

@Transactional
@Repository
public class IngredientsRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;



    public Ingredients getById(Long id){

       return em.find(Ingredients.class,id);

    }



    public Ingredients save(Ingredients ingredients){
        if(ingredients.getId() == null){
            em.persist(ingredients);
        }else {
            em.merge(ingredients);
        }

        return ingredients;
    }

    public void removeById(Long id){

        Ingredients ingredient = getById(id);

        em.remove(ingredient);
    }

    public List<Ingredients> getAll(){

        Query query = em.createQuery("select i from Ingredients i",Ingredients.class);

        List<Ingredients> resultList = query.getResultList();

        return resultList;


    }

    public Ingredients getByName(String name){

        Query query = em.createQuery("select i from Ingredients i where name = " + name ,Ingredients.class);

         return (Ingredients) query.getResultList().get(0);


    }


}

