package com.ns.WeatherAppication.service;

import com.ns.WeatherAppication.model.*;
import com.ns.WeatherAppication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.ns.WeatherAppication.common.Constants.*;

@Service
public class CurrentWeatherService {

    @Autowired
    HourlyWeatherRepository hourlyWeatherRepository;


    @Autowired
    CityRepository cityRepository;

    @Autowired
    CoordinatesRepository coordinatesRepository;

    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    DailyWeatherRepository dailyWeatherRepository;

    @Autowired
    CountryRepository countryRepository;


    //Get the Current Weather Details from API and store in DB
    @Scheduled(cron = "0 */15 * ? * *")
    public CurrentWeatherResonseModel currentWeatherDetails() {
        RestTemplate restTemplate=new RestTemplate();

        List<City> city = cityRepository.findAll();
        WeatherTemplateModel response= new WeatherTemplateModel();
        List<WeatherTemplateModel> output=new ArrayList<WeatherTemplateModel>();
        CurrentWeather currentWeather;
        CurrentWeatherResonseModel currentWeatherResonseModel=new CurrentWeatherResonseModel();
        try {

            for (City cities : city) {
                currentWeather = new CurrentWeather();
                Coordinates coordinate= coordinatesRepository.findByCityId(cities.getCityid().toString());
                CurrentWeather current=currentWeatherRepository.findByCityName(cities.getCityname());
                String surl = currentWeatherUrl + cities.getCityname() + appid + API_KEY;
                response = restTemplate.getForObject(surl, WeatherTemplateModel.class);
                Integer kelvin=273;
                Integer temp= response.getModel().getTemp()- kelvin;
                Integer feelslike= response.getModel().getFeels_like()- kelvin;
                Timestamp timestamp = new Timestamp(Integer.parseInt(response.getDt()) * 1000L);
                if(coordinate==null) {
                    Coordinates coordinates = new Coordinates();
                    coordinates.setLat(response.getCoord().getLat());
                    coordinates.setLon(response.getCoord().getLon());
                    coordinates.setCity(cities);
                    coordinates.setCityName(cities.getCityname());
                    coordinatesRepository.save(coordinates);
                }
                if(current==null) {
                    currentWeather.setCity(cities);
                    currentWeather.setCityName(cities.getCityname());
                    currentWeather.setCurrentWeather(temp);
                    currentWeather.setHumidity(response.getModel().getHumidity());
                    currentWeather.setPressure(response.getModel().getPressure());
                    currentWeather.setDt(timestamp.toString());
                    currentWeather.setFeels_like(feelslike);
                    currentWeather.setWind_speed(response.getSpeedmodel().getSpeed());
                currentWeatherRepository.save(currentWeather);
                }
                else {
                    current.setCity(cities);
                    current.setCityName(cities.getCityname());
                    current.setCurrentWeather(temp);
                    current.setHumidity(response.getModel().getHumidity());
                    current.setPressure(response.getModel().getPressure());
                    current.setId(current.getId());
                    current.setDt(timestamp.toString());
                    current.setFeels_like(feelslike);
                    current.setWind_speed(response.getSpeedmodel().getSpeed());
                    currentWeatherRepository.saveAndFlush(current);
                }
                output.add(response);
                currentWeatherResonseModel= weatherMessage(output,Api_Success,true);

            }
        }
        catch (Exception e)
        {
            currentWeatherResonseModel=weatherMessage(output,Api_Fail,false);
        }
        return currentWeatherResonseModel;
    }

    // retieve the data from DB and return

    public CurrentWeatherResponse displayCurrentWeather(@PathVariable("countryName") String countryName)
    {
        Country country= countryRepository.findByCountryName(countryName);
            List<City> city= cityRepository.findByCountryId(country.getcID().toString());
            List<CurrentWeather> currentWeatherList=new ArrayList<CurrentWeather>();
            CurrentWeatherResponse currentWeatherResponse=new CurrentWeatherResponse();
            try {
                if (city!= null) {
                    for (City cities : city) {
                        CurrentWeather currentWeather = new CurrentWeather();
                        currentWeather = currentWeatherRepository.findByCityName(cities.getCityname());
                        currentWeatherList.add(currentWeather);
                        currentWeatherResponse=currentWeatherMessage(currentWeatherList,Current_Weather_Success,true);
                    }
                }
                else
                {
                    currentWeatherResponse=currentWeatherMessage(currentWeatherList,Empty_City,false);
                }
            }
            catch (Exception e)
            {
                currentWeatherResponse=currentWeatherMessage(currentWeatherList,e.getMessage(),false);
            }
            return currentWeatherResponse;
    }


    //Get the hourly data from API and store in the DB

    @Scheduled(cron = "0 */15 * ? * *")
    public List<HourlyWeatherModel> displayHourlyWeather() {

            RestTemplate restTemplate = new RestTemplate();

            List<HourlyWeatherModel> output = new ArrayList<HourlyWeatherModel>();
            List<Coordinates> coordinates = coordinatesRepository.findAll();
            HourlyWeatherModel response = new HourlyWeatherModel();

            try{
                HourlyWeather hourlyWeather;
            for (Coordinates coord : coordinates) {

                    String surl = url + latitude + coord.getLat() + longitude + coord.getLon() + exclude + appid + API_KEY;
                    response = restTemplate.getForObject(surl, HourlyWeatherModel.class);

                    for (HourlyWeather res : response.getHourly().stream().limit(24).collect(Collectors.toList())) {
                        Timestamp timestamp = new Timestamp(Integer.parseInt(res.getDt()) * 1000L);
                        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timestamp.toString());
                        String newstr = new SimpleDateFormat("HH:mm").format(date);
                        Integer kelvin=273;
                        Integer temp= res.getTemp()- kelvin;
                        Integer feelslike= res.getFeels_like()- kelvin;
                            HourlyWeather hourly = hourlyWeatherRepository.findByCityIdAndDateTime(coord.getCity().getCityid(), newstr);
                            if(hourly==null)
                            {
                                hourlyWeather = new HourlyWeather();
                                hourlyWeather.setDt(timestamp.toString());
                                hourlyWeather.setCity(coord.getCity());
                                hourlyWeather.setTemp(temp);
                                hourlyWeather.setFeels_like(feelslike);
                                hourlyWeather.setPressure(res.getPressure());
                                hourlyWeather.setHumidity(res.getHumidity());
                                hourlyWeather.setWind_speed(res.getWind_speed());
                                hourlyWeatherRepository.save(hourlyWeather);
                            }
                        else {
                                hourly.setDt(timestamp.toString());
                                hourly.setCity(coord.getCity());
                                hourly.setTemp(temp);
                                hourly.setFeels_like(feelslike);
                                hourly.setPressure(res.getPressure());
                                hourly.setHumidity(res.getHumidity());
                                hourly.setWind_speed(res.getWind_speed());
                                hourlyWeatherRepository.saveAndFlush(hourly);
                            }
                    }
                }
            output.add(response);
        }
        catch (Exception e) {
                System.out.println(e);
        }
        return output;
    }

    //Retrieve the data from DB and return

    public HourlyWeatherResponseModel hourlyWeatherDetails(@PathVariable("countryName") String countryName)
    {
        List<City> city= cityRepository.findByCountryId(countryName);
        List hourlyWeatherList=new ArrayList<>();
        HourlyWeatherResponseModel hourlyWeatherResponseModel=new HourlyWeatherResponseModel();
        try {
            for (City cities : city) {
                if(cities!=null) {
                    List<HourlyWeather> hourlyWeather = new ArrayList<>();
                    hourlyWeather = hourlyWeatherRepository.findByCityId(cities.getCityid());
                    hourlyWeatherList.add(hourlyWeather);
                    hourlyWeatherResponseModel=hourlyWeatherMessage(hourlyWeatherList,Hourly_Weather_Success,true);
                }
                else
                {
                    hourlyWeatherResponseModel=hourlyWeatherMessage(hourlyWeatherList,Hourly_Weather_Fail,false);
                }
            }
        }
        catch (Exception e)
        {
            hourlyWeatherResponseModel=hourlyWeatherMessage(hourlyWeatherList,e.getMessage(),false);
        }
        return hourlyWeatherResponseModel;
    }



    public CurrentWeatherResonseModel weatherMessage(List<WeatherTemplateModel> output, String message, boolean success)
    {
        CurrentWeatherResonseModel currentWeatherResonseModel=new CurrentWeatherResonseModel();
        currentWeatherResonseModel.setSuccess(success);
        currentWeatherResonseModel.setMessage(message);
        currentWeatherResonseModel.setWeatherTemplateModel(output);
        return  currentWeatherResonseModel;
    }

    //Error and success Message for Current weather

    public CurrentWeatherResponse currentWeatherMessage(List<CurrentWeather> output, String message, boolean success)
    {
        CurrentWeatherResponse currentWeatherResponse=new CurrentWeatherResponse();
        currentWeatherResponse.setCurrentWeathers(output);
        currentWeatherResponse.setMessage(message);
        currentWeatherResponse.setSuccess(success);
        return  currentWeatherResponse;
    }

    //Error and success Message for hourly weather

    public HourlyWeatherResponseModel hourlyWeatherMessage(List<HourlyWeather> output, String message, boolean success)
    {
       HourlyWeatherResponseModel hourlyWeatherResponseModel=new HourlyWeatherResponseModel();
       hourlyWeatherResponseModel.setMessage(message);
       hourlyWeatherResponseModel.setSuccess(success);
       hourlyWeatherResponseModel.setHourlyWeather(output);
        return  hourlyWeatherResponseModel;
    }

    //Get the Current weather details for a particular city

    public CurrentWeatherForCityModel displayCurrentWeatherForCity(@Param("cityName")String cityName)
    {
       CurrentWeatherForCityModel currentWeatherForCityModel=new CurrentWeatherForCityModel();
        CurrentWeather currentWeather = new CurrentWeather();
        try {
                    currentWeather = currentWeatherRepository.findByCityId(cityName);
                    currentWeatherForCityModel=currentWeatherMessageForCity(currentWeather,Current_Weather_Success,true);

        }
        catch (Exception e)
        {
            currentWeatherForCityModel=currentWeatherMessageForCity(currentWeather,e.getMessage(),false);
        }
        return currentWeatherForCityModel;
    }

    public CurrentWeatherForCityModel currentWeatherMessageForCity(CurrentWeather output, String message, boolean success)
    {
        CurrentWeatherForCityModel currentWeatherForCityModel=new CurrentWeatherForCityModel();
        currentWeatherForCityModel.setCurrentWeathers(output);
        currentWeatherForCityModel.setMessage(message);
        currentWeatherForCityModel.setSuccess(success);
        return  currentWeatherForCityModel;
    }




    public HourlyWeatherForCityModel displayHourlyWeatherForCity(@Param("cityName")String cityName)
    {
       HourlyWeatherForCityModel hourlyWeatherForCityModel = new HourlyWeatherForCityModel();
        List<HourlyWeather> hourlyWeather = new ArrayList<HourlyWeather>();
        CurrentWeather currentWeather = new CurrentWeather();
        try {
            currentWeather = currentWeatherRepository.findByCityId(cityName);
            hourlyWeather = hourlyWeatherRepository.findByCityId(currentWeather.getCity().getCityid());
            hourlyWeatherForCityModel=hourlyWeatherMessageForCity(hourlyWeather,Current_Weather_Success,true);

        }
        catch (Exception e)
        {
            hourlyWeatherForCityModel=hourlyWeatherMessageForCity(hourlyWeather,e.getMessage(),false);
        }
        return hourlyWeatherForCityModel;
    }


    public HourlyWeatherForCityModel hourlyWeatherMessageForCity(List<HourlyWeather> output, String message, boolean success)
    {
        HourlyWeatherForCityModel hourlyWeatherForCityModel = new HourlyWeatherForCityModel();
        hourlyWeatherForCityModel.setHourlyWeather(output);
        hourlyWeatherForCityModel.setMessage(message);
        hourlyWeatherForCityModel.setSuccess(success);
        return  hourlyWeatherForCityModel;
    }





    @Scheduled(cron = "0 */15 * ? * *")
    public List<DailyWeatherModelTwo> dailyWeather() {

        RestTemplate restTemplate = new RestTemplate();

        List<DailyWeatherModelTwo> output = new ArrayList<DailyWeatherModelTwo>();
        List<Coordinates> coordinates = coordinatesRepository.findAll();
        DailyWeatherModelTwo response = new DailyWeatherModelTwo();

        try{
            dailyWeatherRepository.deleteAll();
            DailyWeather dailyWeather;
            for (Coordinates coord : coordinates) {
                String surl = url + latitude + coord.getLat() + longitude + coord.getLon()+daily+ appid + API_KEY;
                response = restTemplate.getForObject(surl, DailyWeatherModelTwo.class);
                    for (DailyWeatherModel dailyWeatherdetails : response.getDaily()) {
                        Timestamp timestamp = new Timestamp(Integer.parseInt(dailyWeatherdetails.getDt()) * 1000L);
                        Integer kelvin = 273;
                        Integer day = dailyWeatherdetails.getTemp().getDay() - kelvin;
                        Integer morning = dailyWeatherdetails.getTemp().getMorn() - kelvin;
                        Integer evening = dailyWeatherdetails.getTemp().getEve() - kelvin;
                        Integer night = dailyWeatherdetails.getTemp().getNight() - kelvin;

                        dailyWeather = new DailyWeather();
                        dailyWeather.setCity(coord.getCity());
                        dailyWeather.setDay(day);
                        dailyWeather.setDt(timestamp.toString());
                        dailyWeather.setEve(evening);
                        dailyWeather.setMorn(morning);
                        dailyWeather.setNight(night);
                        dailyWeather.setHumidity(dailyWeatherdetails.getHumidity());
                        dailyWeather.setPressure(dailyWeatherdetails.getPressure());
                        dailyWeather.setWind_speed(dailyWeatherdetails.getWind_speed());
                        dailyWeatherRepository.save(dailyWeather);
                    }
                }
            output.add(response);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return output;
    }



    public DailyWeatherForCityModel displayDailyWeatherForCity(@Param("cityName")String cityName)
    {
        DailyWeatherForCityModel dailyWeatherForCityModel = new DailyWeatherForCityModel();
        List<DailyWeather> dailyWeather = new ArrayList<DailyWeather>();
        CurrentWeather currentWeather = new CurrentWeather();
        try {
            currentWeather = currentWeatherRepository.findByCityId(cityName);
            dailyWeather = dailyWeatherRepository.findByCityId(currentWeather.getCity().getCityid());
            dailyWeatherForCityModel=dailyWeatherMessageForCity(dailyWeather,Daily_Weather_Success,true);
        }
        catch (Exception e)
        {
            dailyWeatherForCityModel=dailyWeatherMessageForCity(dailyWeather,e.getMessage(),false);
        }
        return dailyWeatherForCityModel;
    }




    public DailyWeatherForCityModel dailyWeatherMessageForCity(List<DailyWeather> output, String message, boolean success)
    {
        DailyWeatherForCityModel dailyWeatherForCityModel = new DailyWeatherForCityModel();
        dailyWeatherForCityModel.setDailyWeather(output);
        dailyWeatherForCityModel.setMessage(message);
        dailyWeatherForCityModel.setSuccess(success);
        return  dailyWeatherForCityModel;
    }

}