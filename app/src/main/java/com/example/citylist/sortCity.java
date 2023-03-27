package com.example.citylist;

import java.util.Comparator;

public class sortCity implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        // Sort this city according to province name
        return city1.getProvinceName().compareTo(city2.getProvinceName());
    }
}
