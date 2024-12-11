package com.airbnb.service;

import com.airbnb.entity.CityEntity;
import com.airbnb.payload.City;
import com.airbnb.repository.CityRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImp implements CityService{

    @Autowired
    private CityRepo cityRepo;
    @Override
    public void createCity(CityEntity city) {

        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

      cityRepo.save(city);

    }


}
