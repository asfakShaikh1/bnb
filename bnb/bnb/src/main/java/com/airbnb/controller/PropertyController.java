package com.airbnb.controller;

import com.airbnb.entity.CityEntity;
import com.airbnb.entity.PropertyEntity;
import com.airbnb.payload.City;
import com.airbnb.payload.Country;
import com.airbnb.payload.Property;
import com.airbnb.repository.PropertyRepo;
import com.airbnb.service.CityService;
import com.airbnb.service.CountryService;
import com.airbnb.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;


    @PostMapping("/property")
    public String CreateProperty(@RequestBody Property property){
        if(property!=null){
            propertyService.createProperty(property);
            return "create property successfully";
        }else{
            return "somthing went to wrong";
        }

    }

    @PostMapping("/city")
    public String createCity(@RequestBody CityEntity city){
            cityService.createCity(city);
            return "Create City successful";
}

@PostMapping("/country")
public String createCountry( @RequestBody Country country){
        if(country!=null){
            countryService.createCountry(country);
            return "Create Country successfully";
        }else{
            return "something went to wrong ";
        }
}



    @GetMapping("/propertysearch")
    public List<Property> searchProperty(@RequestParam("city")String cityName){
        return propertyRepo.searchProperty(cityName);
    }

}
