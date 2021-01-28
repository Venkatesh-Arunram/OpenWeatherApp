package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.CurrentWeather;
import com.ns.WeatherAppication.model.DailyWeather;
import com.ns.WeatherAppication.model.HourlyWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DailyWeatherRepository extends JpaRepository<DailyWeather, Integer> {

    @Query(value = "select * from dailyweather where cityid= :cityId And datetime like %:dT% ;",nativeQuery = true)
    DailyWeather findByCityIdAndDateTime(@Param("cityId") Integer cityId, @Param("dT") String dT);

    @Query(value = "select * from dailyweather where cityid= :cityId ;",nativeQuery = true)
   List<DailyWeather> findByCityId(@Param("cityId") Integer cityId);

//    @Query(value = "select distinct id from dailyweather;",nativeQuery = true)
//    DailyWeather findByCityName();
}
