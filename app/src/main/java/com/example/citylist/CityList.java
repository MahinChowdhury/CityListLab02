package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(boolean flag) {
        List<City> cityList = cities;

        if(flag) {
            //Sort on default
            Collections.sort(cityList);
        }
        else{
            //Sort by province name
            Collections.sort(cityList,new sortCity());
        }
        return cityList;
    }
    //Function to delete a city
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    //Get count of cities.
    public int count(){
        return cities.size();
    }
}
