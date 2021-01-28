package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.TimeZones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeZoneRepository extends JpaRepository<TimeZones,Integer> {

    @Query(value = "select * from timezone where cityid =:cityId ;",nativeQuery = true)
    TimeZones findByCityId(@Param("cityId") Integer cityId);
}
