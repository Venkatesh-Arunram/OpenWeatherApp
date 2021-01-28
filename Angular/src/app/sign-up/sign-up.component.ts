import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { OperWeatherServiceService } from '../oper-weather-service.service';
import { NgxSpinnerService } from "ngx-spinner";
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private service: OperWeatherServiceService,private router: Router,private spinner: NgxSpinnerService,private formBuilder: FormBuilder) { }
  countries: any = [];
  showErrorMessage:boolean;
  userForm: FormGroup;
   countryNames:string;

  ngOnInit() {
    this.getContries();
    this.userForm = this.formBuilder.group({
      userName: ['',  [Validators.required]],
      email: ['', [Validators.required,Validators.email,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
    password: ['', [Validators.required,]],
      country:['', [Validators.required,]]
    });
  }
  getContries() {
    this.service.getCountries().subscribe(x => {
      console.log(x);
      
      this.countries = x;
      err => {
        console.log("error");
      }
    })
  }


  addUser(){
    if((this.userForm.value.password!='')&&(this.userForm.value.userName!='')&&(this.userForm.value.email!=''))
    {
      const emailtext= Base64.encode(this.userForm.value.email);
    const passwordText=Base64.encode(this.userForm.value.password);
    this.countryNames=this.countries.value;
    const userData ={
      "userName":this.userForm.value.userName,
      "email":emailtext,
      "password":passwordText,
      "country":
      {
        "countryName":this.userForm.value.country.countryName
      }
    };
      this.service.register(userData).subscribe(
        (data: any)=>{console.log(data)
     
     if(data.isSuccess)
     {
      this.router.navigate(['Login']);
     }
    else
    {
      this.showErrorMessage=!data.isSuccess
    }
  },
  err => { alert(err)
    });
  }
}
}