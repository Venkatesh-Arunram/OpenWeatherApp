package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.Pressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PressureRepository extends JpaRepository<Pressure,Integer> {
    @Query(value = "select * from pressure where city_id= :cityid ;",nativeQuery = true)
    Pressure findByCityId_Pressure(@Param("cityid") String cityid);
}
