package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {

   // @Query(value = "select cid from country where countryname = :countryName ;",nativeQuery = true)
 //   Integer findCountryName(@Param("countryName") String countryName);

    Country findByCountryName(String countryName);
//    Country findByCId(Integer cid);

}
