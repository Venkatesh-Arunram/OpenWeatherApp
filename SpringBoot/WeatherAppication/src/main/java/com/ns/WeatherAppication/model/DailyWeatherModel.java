package com.ns.WeatherAppication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class DailyWeatherModel {

    @JsonProperty(value = "dt")
    private String dt;
    @JsonProperty(value = "pressure")
    private String pressure;
    @JsonProperty(value = "humidity")
    private String humidity;
    @JsonProperty(value = "wind_speed")
    private String wind_speed;

    @JsonProperty(value = "temp")
    private Temp temp=new Temp();

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }
}
