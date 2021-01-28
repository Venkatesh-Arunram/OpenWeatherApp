package com.ns.WeatherAppication;


import com.ns.WeatherAppication.controller.WeatherController;
import com.ns.WeatherAppication.model.CurrentWeather;
import com.ns.WeatherAppication.repository.CurrentWeatherRepository;
import com.ns.WeatherAppication.service.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@SpringBootApplication
@EnableScheduling
public class WeatherAppicationApplication {

@Autowired
CurrentWeatherService currentWeatherService;



	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherAppicationApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		 currentWeatherService.currentWeatherDetails();
		 currentWeatherService.displayHourlyWeather();
		 currentWeatherService.dailyWeather();
	}

}