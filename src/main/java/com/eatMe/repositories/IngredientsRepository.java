package com.eatMe.repositories;

import com.eatMe.entities.Ingredients;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;

@Transactional
@Repository
public class IngredientsRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Ingredients getById(Long id){

       return em.find(Ingredients.class,id);

    }
}

