package com.ns.WeatherAppication.controller;

import com.ns.WeatherAppication.model.User;
import com.ns.WeatherAppication.model.UserResponseModel;
import com.ns.WeatherAppication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity createUser(@RequestBody User user)
    {
        UserResponseModel userResponseModel=new UserResponseModel();
        if(user==null)
        {
           userResponseModel.setIsSuccess(false);
            return new ResponseEntity(userResponseModel,HttpStatus.BAD_REQUEST);
        }
        UserResponseModel userDetails=userService.adduser(user);
        return Objects.nonNull(userDetails) ? userDetails.getIsSuccess()? new ResponseEntity(userDetails, HttpStatus.OK) : new ResponseEntity(userDetails,HttpStatus.OK) :  new ResponseEntity(userDetails,HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/user/login")
    public ResponseEntity verifyUser(@RequestBody User user)
    {
        UserResponseModel userResponseModel=new UserResponseModel();
        if(user.getPassword()==null|| user.getEmail()==null)
        {
            userResponseModel.setIsSuccess(false);
            return new ResponseEntity(userResponseModel,HttpStatus.BAD_REQUEST);
        }
        UserResponseModel userDetails=userService.loginUser(user);

        return Objects.nonNull(userDetails) ? userDetails.getIsSuccess()? new ResponseEntity(userDetails, HttpStatus.OK) : new ResponseEntity(userDetails,HttpStatus.OK) :  new ResponseEntity(userDetails,HttpStatus.BAD_REQUEST);
    }

}
