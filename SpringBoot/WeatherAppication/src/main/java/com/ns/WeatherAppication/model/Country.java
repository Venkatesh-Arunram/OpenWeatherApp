package com.ns.WeatherAppication.model;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {
    public Country(Integer cID) {
        this.cID = cID;
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cID;

    @Column(name="countryname")
    private String countryName;
//
//    @OneToOne(mappedBy = "country")
//    private User user;

    public Country(){}

    public Integer getcID() {
        return cID;
    }

    public void setcID(Integer cID) {
        this.cID = cID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
