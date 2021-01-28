package com.ns.WeatherAppication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class Temp {


    private Integer day;

    private Integer morn;

    private Integer eve;
  
    private Integer night;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMorn() {
        return morn;
    }

    public void setMorn(Integer morn) {
        this.morn = morn;
    }

    public Integer getEve() {
        return eve;
    }

    public void setEve(Integer eve) {
        this.eve = eve;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }
}
