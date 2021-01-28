package com.ns.WeatherAppication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherTemplateModel {
    private LatitudeLongitude coord;
    private String temp;
    @JsonProperty(value = "main")
    private TempModel model= new TempModel();
    @JsonProperty(value = "wind")
    private WindModel speedmodel= new WindModel();

    private String dt;

    private String name;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public LatitudeLongitude getCoord() {
        return coord;
    }

    public void setCoord(LatitudeLongitude coord) {
        this.coord = coord;
    }

    public TempModel getModel() {
        return model;
    }

    public void setModel(TempModel model) {
        this.model = model;
    }

    public WindModel getSpeedmodel() {
        return speedmodel;
    }

    public void setSpeedmodel(WindModel speedmodel) {
        this.speedmodel = speedmodel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherTemplateModel{" +
                "coord=" + coord +
                ", name='" + name + '\'' +
                '}';
    }
}