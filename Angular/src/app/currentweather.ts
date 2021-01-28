import { CityComponent } from './city/city.component';
import { City } from './citydetails';

export class CurrentWeather {
    city:City
    currentWeather: number
    cityName: string;
    dt:string;
    feels_like:number;
    humidity:string;
    id:number;
    pressure:string;
    wind_speed: string;
  }