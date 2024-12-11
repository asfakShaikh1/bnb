package com.airbnb.payload;

import com.airbnb.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Property {

    private String name;
    private Integer numberOfGuests;
    private Integer numberOfBeds;
    private Integer numberOfBathrooms;
    private Integer numberOfBedRooms;
   // private CountryEntity country;
}
