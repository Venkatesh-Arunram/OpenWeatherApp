import { Component, OnInit } from '@angular/core';
import { OperWeatherServiceService } from '../oper-weather-service.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { NgxSpinnerService } from "ngx-spinner";
import swal from 'sweetalert2';
import { Base64 } from 'js-base64';
import { LoginResponse } from '../login-response';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  showErrorMessage:boolean;
  loginForm: FormGroup;
  token: any;
  constructor(private service: OperWeatherServiceService, private router: Router,private formBuilder: FormBuilder,public spinner: NgxSpinnerService) { }

  ngOnInit() {
  
  this.loginForm = this.formBuilder.group({
    email: ['', [Validators.required,Validators.email,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
    password: ['', [Validators.required,]],
  });
  }

  login() {
     const emailtext= Base64.encode(this.loginForm.value.email);
    const passwordText=Base64.encode(this.loginForm.value.password);
    if ((this.loginForm.value.password != '' && this.loginForm.value.email != '')) {
      const usedata ={
        "email" : emailtext,
        "password" : passwordText
      };
      this.service.login(usedata).subscribe(
        (res: LoginResponse) => {
          console.log(res);
          if(!res.isSuccess)
          {
            this.showErrorMessage=!res.isSuccess
          }
          else{
            localStorage.setItem('token', res.token);
          localStorage.setItem('countryname', res.countryName)
          this.router.navigate(['City']);          
          }
        },
        err => {
          alert(err)
        }
      );
    }
  }
}