package com.eatMe.repositories;


import com.eatMe.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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


}
