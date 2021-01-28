package com.ns.WeatherAppication.model;

import javax.persistence.*;

@Entity
@Table(name="humidity")
public class Humidity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "12am")
    private String twelveAm;

    @Column(name = "2am")
    private String twoAm;

    @Column(name = "4am")
    private String fourAm;

    @Column(name = "6am")
    private String sixAm;

    @Column(name = "8am")
    private String eightAm;

    @Column(name = "10am")
    private String tenAm;

    @Column(name = "12pm")
    private String twelvePm;

    @Column(name = "2pm")
    private String twoPm;

    @Column(name = "4pm")
    private String fourPm;

    @Column(name = "6pm")
    private String sixPm;

    @Column(name = "8pm")
    private String eightPm;

    @Column(name = "10pm")
    private String tenPm;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId")
    private City cityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTwelveAm() {
        return twelveAm;
    }

    public void setTwelveAm(String twelveAm) {
        this.twelveAm = twelveAm;
    }

    public String getTwoAm() {
        return twoAm;
    }

    public void setTwoAm(String twoAm) {
        this.twoAm = twoAm;
    }

    public String getFourAm() {
        return fourAm;
    }

    public void setFourAm(String fourAm) {
        this.fourAm = fourAm;
    }

    public String getSixAm() {
        return sixAm;
    }

    public void setSixAm(String sixAm) {
        this.sixAm = sixAm;
    }

    public String getEightAm() {
        return eightAm;
    }

    public void setEightAm(String eightAm) {
        this.eightAm = eightAm;
    }

    public String getTenAm() {
        return tenAm;
    }

    public void setTenAm(String tenAm) {
        this.tenAm = tenAm;
    }

    public String getTwelvePm() {
        return twelvePm;
    }

    public void setTwelvePm(String twelvePm) {
        this.twelvePm = twelvePm;
    }

    public String getTwoPm() {
        return twoPm;
    }

    public void setTwoPm(String twoPm) {
        this.twoPm = twoPm;
    }

    public String getFourPm() {
        return fourPm;
    }

    public void setFourPm(String fourPm) {
        this.fourPm = fourPm;
    }

    public String getSixPm() {
        return sixPm;
    }

    public void setSixPm(String sixPm) {
        this.sixPm = sixPm;
    }

    public String getEightPm() {
        return eightPm;
    }

    public void setEightPm(String eightPm) {
        this.eightPm = eightPm;
    }

    public String getTenPm() {
        return tenPm;
    }

    public void setTenPm(String tenPm) {
        this.tenPm = tenPm;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }
}
