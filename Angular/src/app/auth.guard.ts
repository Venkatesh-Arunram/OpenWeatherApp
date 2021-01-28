import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, Route, CanDeactivate } from '@angular/router';
import { Observable } from 'rxjs';
import { OperWeatherServiceService } from './oper-weather-service.service';

@Injectable()
export class AuthGuard implements CanActivate {


  constructor(private service: OperWeatherServiceService, private _router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (localStorage.getItem("token")) {
      return true;
    }
    this._router.navigate(['']);
    return false;
  }
}
