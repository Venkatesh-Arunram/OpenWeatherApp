package com.ns.WeatherAppication.model;

import java.util.List;

public class CurrentWeatherForCityModel {
    private boolean isSuccess;
    private String message;
    private CurrentWeather currentWeathers;

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

    public CurrentWeather getCurrentWeathers() {
        return currentWeathers;
    }

    public void setCurrentWeathers(CurrentWeather currentWeathers) {
        this.currentWeathers = currentWeathers;
    }
}
