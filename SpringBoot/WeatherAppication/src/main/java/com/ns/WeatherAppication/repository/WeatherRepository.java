package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.City;
import com.ns.WeatherAppication.model.WeatherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeatherRepository extends JpaRepository<City,Integer> {

    @Query(value = "select * from city where country_id= :countryId ;",nativeQuery = true)
   List<City> findByCountryID(@Param("countryId") String countryId);

}
