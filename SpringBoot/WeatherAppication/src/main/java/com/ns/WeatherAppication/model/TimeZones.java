package com.ns.WeatherAppication.model;


import javax.persistence.*;

@Entity
@Table(name="timezone")
public class TimeZones {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="timezones")
    private String timezones;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityid")
    private City cityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimezones() {
        return timezones;
    }

    public void setTimezones(String timezones) {
        this.timezones = timezones;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }
}
