package com.airbnb.payload;

public class City {
    public String name() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    private String name;
}
