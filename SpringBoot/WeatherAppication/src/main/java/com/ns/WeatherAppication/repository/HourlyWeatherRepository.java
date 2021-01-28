package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.City;
import com.ns.WeatherAppication.model.CurrentWeather;
import com.ns.WeatherAppication.model.HourlyWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HourlyWeatherRepository extends JpaRepository<HourlyWeather, Integer> {

    @Query(value = "select * from hourlyweather where cityId= :cityId ;",nativeQuery = true)
    List< HourlyWeather> findByCityId(@Param("cityId") Integer cityId);


    @Query(value = "select * from hourlyweather where cityid= :cityId And datetime like %:dT% ;",nativeQuery = true)
    HourlyWeather findByCityIdAndDateTime(@Param("cityId") Integer cityId, @Param("dT") String dT);


    @Query(value = "select * from hourlyweather where id= :Id ;",nativeQuery = true)
    HourlyWeather findByHourlyId(@Param("Id") String Id);

    @Modifying
    @Query(value = "update hourlyweather set datetime= :dateTime,feelslike= :feelslike , humidity= :humidity, pressure= :pressure, cityid= :cityId, temp= :temp,windspeed= :windspeed  where id= :id ;",nativeQuery = true)
    HourlyWeather updateById(@Param("dateTime") String dateTime, @Param("feelslike") String feelslike,@Param("humidity") String humidity ,@Param("pressure") String pressure,@Param("temp") String temp ,@Param("windspeed") String windspeed ,@Param("cityId") Integer cityId, @Param("id") Integer id);




}
