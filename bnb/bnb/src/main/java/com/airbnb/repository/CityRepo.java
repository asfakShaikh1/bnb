package com.airbnb.repository;

import com.airbnb.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CityRepo extends JpaRepository<CityEntity,Long> {
}
