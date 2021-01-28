import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { WeatherComponent } from './weather/weather.component';
import {MatCardModule} from '@angular/material/card';
import { CityComponent } from './city/city.component';
import { AppMaterialModule } from './app-material-module';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { AuthGuard } from './auth.guard';

const routes: Routes = [{path:'', redirectTo: 'Login', pathMatch: 'full'},
{path:'SignUp',component:SignUpComponent},
{path:'Weather',component:WeatherComponent, canActivate: [AuthGuard]},
{path:'City',component:CityComponent,canActivate: [AuthGuard],
children: [
  {
      path:'Weather',pathMatch: 'full',// child route path
      component: WeatherComponent  // child route component that the router renders
  }]},
{path:'Login',component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes),MatCardModule,AppMaterialModule,MatProgressSpinnerModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
