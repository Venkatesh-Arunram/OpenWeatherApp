package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeatherWeekRepository extends JpaRepository<Weather,Integer> {

    @Query(value = "select * from weather where city_id= :cityid ;",nativeQuery = true)
    List<Weather> findByCityID(@Param("cityid") String cityid);







}
