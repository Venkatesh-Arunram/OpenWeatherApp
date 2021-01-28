package com.ns.WeatherAppication.controller;


import com.ns.WeatherAppication.model.City;
import com.ns.WeatherAppication.model.Country;
import com.ns.WeatherAppication.repository.CityRepository;
import com.ns.WeatherAppication.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CityRepository cityRepository;


    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country)
    {
        return countryRepository.save(country);
    }

    @GetMapping("/countries")
    public List<Country> displayCountry()
    {
        return countryRepository.findAll();
    }

    @GetMapping("/country/{countryName}/cities")
    public List<City> displayCity(@PathVariable("countryName") String countryName)
    {
        Country country=countryRepository.findByCountryName(countryName);
        return cityRepository.findByCountryId(country.getcID().toString());
    }
}
