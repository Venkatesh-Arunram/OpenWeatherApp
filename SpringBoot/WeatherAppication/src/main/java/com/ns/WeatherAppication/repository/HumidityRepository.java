package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HumidityRepository extends JpaRepository<Humidity,Integer> {
    @Query(value = "select * from humidity where city_id= :cityid ;",nativeQuery = true)
    Humidity findByCityId_Humid(@Param("cityid") String cityid);
}
