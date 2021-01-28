package com.ns.WeatherAppication.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;

    @NotEmpty(message = "username is required")
    @Column(name="username")
    private String userName;

    @NotEmpty(message = "Email is required")
    @Email
    @Column(name="email")
    private String email;

    @NotEmpty(message = "password is required")
    @Column(name="password")
    private String password;

    @Column(name="token")
    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId")
    private Country country;

    public  User()
    {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
