import { Component, OnInit, ViewChild, Input, Output, EventEmitter, ChangeDetectorRef } from '@angular/core';
import { OperWeatherServiceService } from '../oper-weather-service.service';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { HourlyWeather } from '../Hourlyweather';
import { CityComponent } from '../city/city.component';
import { CurrentWeathers } from '../city/current';
import { CurrentWeather } from '../currentweather';
import { Subscription } from 'rxjs';
import { MessageserviceService } from '../messageservice.service';
@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  messages: any={};
  subscription: Subscription;
  cityCw: any = '';
  country: any = '';
  city: any = '';
  CW: any = '';
  hourlyWeatherForcity: any;
  owlOptions = {
    margin: 25,
    nav: true,
    navText: ["<div class='nav-btn prev-slide'></div>", "<div class='nav-btn next-slide'></div>"],
    responsiveClass: true,
    responsive: {
      0: {
        items: 2,
        nav: true
      },
      600: {
        items: 4,
        nav: true
      },
      1000: {
        items: 4,
        nav: true,
        loop: false
      },
      1400: {
        items: 5,
        nav: true,
        loop: false
      }
    }
  }
  constructor(private changeDetector: ChangeDetectorRef,private messageService: MessageserviceService,private service: OperWeatherServiceService, private router: Router, private spinner: NgxSpinnerService) { 
    
  // this.subscription=  this.messageService.getMessage().subscribe((message: CurrentWeather)=> {     

}


  ngOnInit() {
    this.spinner.show();
    this.service.getCurrentWeatherForCity(localStorage.getItem('countryNameForOneCity'), localStorage.getItem('cityname'), localStorage.getItem('token')).subscribe((hourlyforcity: HourlyWeather) => {
      this.spinner.hide();
      console.log(hourlyforcity);
      this.hourlyWeatherForcity = hourlyforcity.hourlyWeather;
    },
    err => {
      alert(err)
    }
    );
// console.log("city",this.messageService.city)

//     this.subscription=this.messageService.getMessage().subscribe((mes: CurrentWeathers)=>{
//       this.messages=mes;
//       console.log("mess",this.messages);
//       console.log("pressure",this.messages.message.pressure);
//     this.pressure=this.messages.message.pressure;
//     this.windspeed=this.messages.message.wind_speed;
//       });
    // console.log("pressure",this.messages.message.pressure);
    // this.pressure=this.messages.message.pressure;
    this.country = localStorage.getItem("countryNameForOneCity");
    this.city = localStorage.getItem("cityname");
    this.cityCw = localStorage.getItem('city');
    this.CW=JSON.parse(this.cityCw)
  }
}
