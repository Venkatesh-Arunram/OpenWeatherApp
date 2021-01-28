package com.ns.WeatherAppication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherModel {

    @JsonProperty(value = "hourly")
    private List<HourlyWeather> hourly=new ArrayList<HourlyWeather>();



    public List<HourlyWeather> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyWeather> hourly) {
        this.hourly = hourly;
    }


}
