package com.airbnb.service;

import com.airbnb.entity.PropertyEntity;
import com.airbnb.payload.Property;
import com.airbnb.repository.PropertyRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropertyImp implements PropertyService{

    @Autowired
    private PropertyRepo propertyRepo;
    @Override
    public void createProperty(Property property) {
        PropertyEntity entity = new PropertyEntity();

        BeanUtils.copyProperties(entity,property);
     propertyRepo.save(entity);


    }
}
