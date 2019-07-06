package com.eatMe.repositories;

import com.eatMe.entities.Adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class AdresRepository {

    @Autowired
    EntityManager em;


    public Adres getAdresByRestaurantId(Long restaurantId){

        String queryString ="select a from Adres a join a.restaurant r where r.id =:id";
        Query query = em.createQuery(queryString)
                .setParameter("id",restaurantId);

        return(Adres) query.getResultList().get(0);
    }


}
