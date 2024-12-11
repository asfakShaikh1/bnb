package com.airbnb.service;

import com.airbnb.entity.CountryEntity;
import com.airbnb.payload.Country;
import com.airbnb.repository.CountryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepo countryRepo;
    @Override
    public void createCountry(Country country) {
        CountryEntity entity = new CountryEntity();
      if(country!=null) {
          BeanUtils.copyProperties(country, entity);
          countryRepo.save(entity);

      }

    }
}
