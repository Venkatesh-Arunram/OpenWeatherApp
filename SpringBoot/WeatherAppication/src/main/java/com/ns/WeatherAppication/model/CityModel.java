package com.ns.WeatherAppication.model;

import java.util.List;

public class CityModel {

    private City cityDetails;
    private String time;

    public City getCity() {
        return cityDetails;
    }

    public void setCity(City cityDetails) {
        this.cityDetails = cityDetails;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
