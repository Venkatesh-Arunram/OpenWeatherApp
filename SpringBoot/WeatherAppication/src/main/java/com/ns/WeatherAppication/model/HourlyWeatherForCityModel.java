package com.ns.WeatherAppication.model;

import java.util.List;

public class HourlyWeatherForCityModel {

    private boolean isSuccess;
    private String message;
    private List<HourlyWeather> hourlyWeather;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HourlyWeather> getHourlyWeather() {
        return hourlyWeather;
    }

    public void setHourlyWeather(List<HourlyWeather> hourlyWeather) {
        this.hourlyWeather = hourlyWeather;
    }
}
