package com.ns.WeatherAppication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DailyWeatherModelTwo {

    @JsonProperty(value = "daily")
    private List<DailyWeatherModel> daily=new ArrayList<DailyWeatherModel>();

    public List<DailyWeatherModel> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyWeatherModel> daily) {
        this.daily = daily;
    }
}
