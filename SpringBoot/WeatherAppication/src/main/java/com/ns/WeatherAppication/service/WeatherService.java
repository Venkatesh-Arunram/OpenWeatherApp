package com.ns.WeatherAppication.service;

import com.ns.WeatherAppication.model.*;
import com.ns.WeatherAppication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.TimeZone;

import static com.ns.WeatherAppication.common.Constants.*;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    WeatherWeekRepository weatherWeekRepository;

    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    PressureRepository pressureRepository;

    @Autowired
    HumidityRepository humidityRepository;

    @Autowired
    TimeZoneRepository timeZoneRepository;


//    public DisplayCityModel displaycities(@PathVariable("countryId") String countryId) {
//        DisplayCityModel displayCityModel = new DisplayCityModel();
//        List<CityModel> cityModelList = new ArrayList<CityModel>();
//        CityModel cityModel=new CityModel();
//        Calendar calendar = Calendar.getInstance();
//        List<City> cities = weatherRepository.findByCountryID(countryId);
//
//        for (City cityname:cities) {
//            TimeZones timeZones= timeZoneRepository.findByCityId(cityname.getCityid());
//            calendar.setTimeZone(TimeZone.getTimeZone(timeZones.getTimezones()));
//            String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
//            if(calendar.get(Calendar.AM_PM)==1)
//            {
//                time=time+ " PM";
//            }
//            else
//            {
//                time=time+ " AM";
//            }
//            cityModel.setCity(cityname);
//            cityModel.setTime(time);
//            cityModelList.add(cityModel);
//            cityModel=new CityModel();
//        }
//        displayCityModel.setCityModel(cityModelList);
//        return displayCityModel;
//    }

    public List<Weather> displayWeather(@PathVariable("cityid") String cityid)
    {
        List<Weather> cities = weatherWeekRepository.findByCityID(cityid);
        return cities;
    }

    public WeatherModel displayTemperatureHumidityPressure(@PathVariable("cityid") String cityid)
    {
        Temperature temperatures= temperatureRepository.findByCityId_Temp(cityid);
        Pressure pressures= pressureRepository.findByCityId_Pressure(cityid);
        Humidity humidities= humidityRepository.findByCityId_Humid(cityid);
        WeatherModel weatherModel =new WeatherModel();
        weatherModel.setHumidity(humidities);
        weatherModel.setTemperature(temperatures);
        weatherModel.setPressure(pressures);
        weatherModel.setCityid(Integer.parseInt(cityid));
        return weatherModel;
    }
}
