package com.airbnb.repository;

import com.airbnb.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CountryRepo extends JpaRepository<CountryEntity, Long> {
}
