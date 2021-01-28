package com.ns.WeatherAppication.model;

import java.util.List;

public class CurrentWeatherResonseModel {

    private boolean isSuccess;
    private String message;
    private List<WeatherTemplateModel> weatherTemplateModel;

    public List<WeatherTemplateModel> getWeatherTemplateModel() {
        return weatherTemplateModel;
    }

    public void setWeatherTemplateModel(List<WeatherTemplateModel> weatherTemplateModel) {
        this.weatherTemplateModel = weatherTemplateModel;
    }

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
}
