package com.ns.WeatherAppication.model;

import java.util.List;

public class CurrentWeatherResponse {
    private boolean isSuccess;
    private String message;
    private List<CurrentWeather> currentWeathers;

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

    public List<CurrentWeather> getCurrentWeathers() {
        return currentWeathers;
    }

    public void setCurrentWeathers(List<CurrentWeather> currentWeathers) {
        this.currentWeathers = currentWeathers;
    }
}
