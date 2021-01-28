package com.ns.WeatherAppication.model;


import javax.persistence.*;

@Entity
@Table(name="currentweather")
public class CurrentWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "datetime")
    private String dt;

    @Column(name = "currentweather")
    private Integer currentWeather;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "humidity")
    private String humidity;
    @Column(name = "feelslike")
    private Integer feels_like;

    @Column(name = "windspeed")
    private String wind_speed;

    @Column(name = "cityname")
    private String cityName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityid")
    private City city;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Integer getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(Integer currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Integer feels_like) {
        this.feels_like = feels_like;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }
}
