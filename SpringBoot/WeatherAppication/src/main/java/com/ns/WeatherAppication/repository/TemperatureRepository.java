package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TemperatureRepository extends JpaRepository<Temperature,Integer> {

    @Query(value = "select * from temperature where city_id= :cityid ;",nativeQuery = true)
    Temperature findByCityId_Temp(@Param("cityid") String cityid);
}
