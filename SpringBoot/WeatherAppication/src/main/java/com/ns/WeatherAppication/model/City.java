package com.ns.WeatherAppication.model;


import javax.persistence.*;

@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cityid;

    @Column(name = "cityname")
    private String cityname;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId")
    private Country country;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}