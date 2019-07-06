package com.eatMe.services;

import com.eatMe.entities.Adres;
import com.eatMe.repositories.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresService {

    @Autowired
    AdresRepository adresRepository;

    public Adres getByRestaurantId(Long restaurantId){

        return adresRepository.getAdresByRestaurantId(restaurantId);
    }
}
