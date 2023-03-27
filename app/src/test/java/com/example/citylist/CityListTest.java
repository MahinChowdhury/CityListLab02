package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(true).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(true).size());
        assertTrue(cityList.getCities(true).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    //Run test for GetCities function.
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(true).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(true).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(true).get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(false).get(1)));
    }

    //To test the City delete function
    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        City city1 = new City("Dhaka","Bangladesh");
        cityList.add(city1);

        cityList.delete(city);

        assertTrue(!cityList.getCities(true).contains(city));
    }
    //Testing on exception thrown on city delete function
    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        City city1 = new City("Dhaka","Bangladesh");
        cityList.add(city1);

        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () ->{
           cityList.delete(city);
        });

    }

    //Run test on city Count method
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        City city1 = new City("Dhaka","Bangladesh");
        cityList.add(city1);
        City city3 = new City("Lisbon","Portugal");
        cityList.add(city3);

        assertEquals(3,cityList.getCities(true).size());
    }

}
