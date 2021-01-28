package com.ns.WeatherAppication.model;


import javax.persistence.*;

@Entity
@Table(name="dailyweather")
public class DailyWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "datetime")
    private String dt;
    @Column(name = "pressure")
    private String pressure;
    @Column(name = "humidity")
    private String humidity;
    @Column(name = "windspeed")
    private String wind_speed;
    @Column(name = "Day")
    private Integer day;
    @Column(name = "Morning")
    private Integer morn;
    @Column(name = "Evening")
    private Integer eve;
    @Column(name = "Night")
    private Integer night;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityid")
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
