package com.ns.WeatherAppication.common;

public class Constants {
    public Constants() {
    }

    public static final String Signup_Fail = "Signup failed";
    public static final String Signup_Success = "Successfully signed up";
    public static final String Login_Fail = "Login unsuccessful";
    public static final String Login_Success = "Login Successful";
    public static final String Incorrect = "Incorrect Username or password.";
    public static final String Already_Exist = "Email already Exist";
    public static final String Not_Registered = "Email not registered";
    public static final String No_Country = "Country Not Available";
    public static final String Api_Success = "Coordinate and Current Weather Successfully stored in DB";
    public static final String Api_Fail = "Coordinate and Current Weather retrieval Failed";
    public static final String Email_Exist = "This Email-Id already exist.";


    public static final String Empty_City = "There is no city";

    public static final String Current_Weather_Success = "Current Weather details succesfully retrieved";

    public static final String Hourly_Weather_Success = "Hourly Weather details succesfully retrieved";


    public static final String Daily_Weather_Success = "Daily Weather details succesfully retrieved";


    public static final String Hourly_Weather_Added = "Hourly Weather details succesfully added";

    public static final String Hourly_Weather_Fail = "No Cities Available";

    public  static final String API_KEY = "e73297f29f4d68f0b0ae33ffa416c6db";

    public static  final  String url = "https://api.openweathermap.org/data/2.5/onecall?";

    public static  final String exclude="&exclude=current,minutely,daily";

    public static  final String daily="&exclude=current,minutely,hourly";

    public  static  final String latitude= "lat=";

    public  static  final String longitude= "&lon=";

    public  static  final  String currentWeatherUrl="https://api.openweathermap.org/data/2.5/weather?q=";

    public  static  final  String appid= "&appid=";
}
