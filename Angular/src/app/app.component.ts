import { Component } from '@angular/core';
import { OperWeatherServiceService } from './oper-weather-service.service';
import { Router, NavigationStart } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'OpenWeatherMap';
  routerurl:string;
  showLogout: Boolean;
  constructor(private service: OperWeatherServiceService,private  router:Router,public spinner: NgxSpinnerService) {
    router.events.forEach(event => {
      if (event instanceof NavigationStart) {
        this.routerurl = event.url.slice(1);
       console.log(this.routerurl);
      }
   })
  }
  ngOnInit()
  {
    this.showLogout===true
  }
  logout()
  {
      localStorage.clear();
      this.router.navigate(['Login']);
  }
}