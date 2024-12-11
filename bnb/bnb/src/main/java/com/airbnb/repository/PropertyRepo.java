package com.airbnb.repository;

import com.airbnb.entity.PropertyEntity;
import com.airbnb.payload.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface PropertyRepo extends JpaRepository<PropertyEntity,Long> {

    @Query("SELECT p FROM PropertyEntity p JOIN p.city c WHERE c.name = :cityName")
    List<Property> searchProperty(@Param("cityName") String cityName);

}
