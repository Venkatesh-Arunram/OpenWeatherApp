package com.ns.WeatherAppication.controller;


import com.ns.WeatherAppication.model.*;
import com.ns.WeatherAppication.repository.CityRepository;
import com.ns.WeatherAppication.repository.CountryRepository;
import com.ns.WeatherAppication.repository.CurrentWeatherRepository;
import com.ns.WeatherAppication.repository.WeatherRepository;
import com.ns.WeatherAppication.service.CurrentWeatherService;
import com.ns.WeatherAppication.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


//Use Only last four APIs

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    CountryRepository countryRepository;

@Autowired
    CurrentWeatherRepository currentWeatherRepository;

@Autowired
    CityRepository cityRepository;

    @Autowired
    WeatherService weatherService;

    @Autowired
    CurrentWeatherService currentWeatherService;

//    @GetMapping("/country/{countryId}/cities")
//    public DisplayCityModel displayCities(@PathVariable("countryId") String countryId)
//    {
//        return weatherService.displaycities(countryId);
//    }

    @GetMapping("/country/{countryId}/city/{cityId}/weather-details")
    public List<Weather> displayWeather( @PathVariable("cityId") String cityId)
    {
        return weatherService.displayWeather(cityId);
    }

    @GetMapping("/country/{countryId}/city/{cityId}/weather-details/temperature")
    public WeatherModel displayTemperatureHumidityPressure( @PathVariable("cityId") String cityId)
    {
        return weatherService.displayTemperatureHumidityPressure(cityId);
    }


    @GetMapping("/country/{countryName}/current-weather-details")
    public ResponseEntity currentWeatherDetails(@PathVariable("countryName") String countryName)
    {
        CurrentWeatherResponse currentWeatherResponse=new CurrentWeatherResponse();
        if(countryName==null)
        {
            currentWeatherResponse.setSuccess(false);
        }
        else
        {
            currentWeatherResponse= currentWeatherService.displayCurrentWeather(countryName);
        }
        return Objects.nonNull(currentWeatherResponse) ? currentWeatherResponse.isSuccess() ? new ResponseEntity(currentWeatherResponse, HttpStatus.OK) : new ResponseEntity(currentWeatherResponse,HttpStatus.INTERNAL_SERVER_ERROR) :  new ResponseEntity(currentWeatherResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/country/{countryName}/hourly-weather-details")
    public ResponseEntity hourlyWeatherDetails(@PathVariable("countryName") String countryName)
    {
        HourlyWeatherResponseModel hourlyWeatherResponseModel=new HourlyWeatherResponseModel();
        if(countryName==null)
        {
            hourlyWeatherResponseModel.setSuccess(false);
        }
        else
        {
            hourlyWeatherResponseModel=currentWeatherService.hourlyWeatherDetails(countryName);
        }
        return Objects.nonNull(hourlyWeatherResponseModel) ? hourlyWeatherResponseModel.isSuccess() ? new ResponseEntity(hourlyWeatherResponseModel, HttpStatus.OK) : new ResponseEntity(hourlyWeatherResponseModel,HttpStatus.INTERNAL_SERVER_ERROR) :  new ResponseEntity(hourlyWeatherResponseModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/country/{countryName}/city/{cityName}/current-weather-details")
    public ResponseEntity displayCurrentWeatherForCity(@PathVariable("cityName") String cityName)
    {
        CurrentWeatherForCityModel currentWeatherForCityModel=new CurrentWeatherForCityModel();
        if(cityName==null)
        {
            currentWeatherForCityModel.setSuccess(false);
        }
        else
        {
            currentWeatherForCityModel= currentWeatherService.displayCurrentWeatherForCity(cityName);
        }
        return Objects.nonNull(currentWeatherForCityModel) ? currentWeatherForCityModel.isSuccess() ? new ResponseEntity(currentWeatherForCityModel, HttpStatus.OK) : new ResponseEntity(currentWeatherForCityModel,HttpStatus.INTERNAL_SERVER_ERROR) :  new ResponseEntity(currentWeatherForCityModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/country/{countryName}/city/{cityName}/hourly-weather-details")
    public ResponseEntity displayHourlyWeatherForCity(@PathVariable("cityName") String cityName)
    {
        HourlyWeatherForCityModel hourlyWeatherForCityModel=new HourlyWeatherForCityModel();
        if(cityName==null)
        {
            hourlyWeatherForCityModel.setSuccess(false);
        }
        else
        {
            hourlyWeatherForCityModel= currentWeatherService.displayHourlyWeatherForCity(cityName);
        }
        return Objects.nonNull(hourlyWeatherForCityModel) ? hourlyWeatherForCityModel.isSuccess() ? new ResponseEntity(hourlyWeatherForCityModel, HttpStatus.OK) : new ResponseEntity(hourlyWeatherForCityModel,HttpStatus.INTERNAL_SERVER_ERROR) :  new ResponseEntity(hourlyWeatherForCityModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/country/{countryName}/city/{cityName}/daily-weather-details")
    public ResponseEntity displayDailyWeatherForCity(@PathVariable("cityName") String cityName)
    {
        DailyWeatherForCityModel dailyWeatherForCityModel=new DailyWeatherForCityModel();
        if(cityName==null)
        {
            dailyWeatherForCityModel.setSuccess(false);
        }
        else
        {
            dailyWeatherForCityModel= currentWeatherService.displayDailyWeatherForCity(cityName);
        }
        return Objects.nonNull(dailyWeatherForCityModel) ? dailyWeatherForCityModel.isSuccess() ? new ResponseEntity(dailyWeatherForCityModel, HttpStatus.OK) : new ResponseEntity(dailyWeatherForCityModel,HttpStatus.BAD_REQUEST) :  new ResponseEntity(dailyWeatherForCityModel,HttpStatus.BAD_REQUEST);
    }
}