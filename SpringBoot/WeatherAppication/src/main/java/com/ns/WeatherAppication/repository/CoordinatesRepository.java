package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.Coordinates;
import com.ns.WeatherAppication.model.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoordinatesRepository extends JpaRepository<Coordinates,Integer> {

    @Query(value = "select * from coordinates where city_id= :cityid ;",nativeQuery = true)
    Coordinates findByCityId(@Param("cityid") String cityid);
}
