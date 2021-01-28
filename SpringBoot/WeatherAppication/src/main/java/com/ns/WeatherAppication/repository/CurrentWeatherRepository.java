package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.CurrentWeather;
import com.ns.WeatherAppication.model.Pressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.management.jdp.JdpPacket;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather,Integer> {


    @Query(value = "select * from currentweather where cityname= :cityName ;",nativeQuery = true)
    CurrentWeather findByCityName(@Param("cityName") String cityName);

    @Query(value = "select * from currentweather where cityname= :cityName ;",nativeQuery = true)
    CurrentWeather findByCityId(@Param("cityName") String cityName);
}
