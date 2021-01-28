package com.ns.WeatherAppication.model;

import javax.persistence.*;

@Entity
@Table(name="coordinates")
public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="latitude")
    private String lat;
    @Column(name="logitude")
    private String lon;

    @Column(name = "cityname")
    private String cityName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId")
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
