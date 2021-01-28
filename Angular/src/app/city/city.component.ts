import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OperWeatherServiceService } from '../oper-weather-service.service';
import { Router } from '@angular/router';
import { NgxSpinnerService } from "ngx-spinner";
import { CurrentWeather } from '../currentweather';
import { CurrentWeathers } from './current';
import { MessageserviceService } from '../messageservice.service';


@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  currentWeather: CurrentWeather;
  constructor(private messageService: MessageserviceService, private service: OperWeatherServiceService, private router: Router, private spinner: NgxSpinnerService) { }
  city: any = [];
  ngOnInit() {
    this.spinner.show();
    this.service.getCurrentWeather(localStorage.getItem('countryname'), localStorage.getItem('token')).subscribe((current: CurrentWeathers) => {
      console.log(current)
      this.spinner.hide();
      this.currentWeather = current.currentWeathers
    },
    err => {
      alert(err)
    }
    );
    
  }

  getcity(ciit) {
    console.log(ciit)
    console.log(ciit.city.cityid)
    console.log(ciit.currentWeather)
    
    localStorage.setItem('cityidforOneCity', ciit.city.cityid)
    localStorage.setItem('countryNameForOneCity', ciit.city.country.countryName)
    localStorage.setItem('cityname', ciit.city.cityname)
    localStorage.setItem('date', ciit.dt)
    localStorage.setItem('currentWeather', ciit.currentWeather)
    localStorage.setItem("city", JSON.stringify(ciit))
    this.router.navigate(['Weather']);
    
  }
}