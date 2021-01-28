package com.ns.WeatherAppication.service;

import com.ns.WeatherAppication.model.Country;
import com.ns.WeatherAppication.model.User;
import com.ns.WeatherAppication.model.UserResponseModel;
import com.ns.WeatherAppication.repository.CountryRepository;
import com.ns.WeatherAppication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

import static com.ns.WeatherAppication.common.Constants.*;

@Service
public class UserService {
private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserService.token = token;
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    CountryRepository countryRepository;




    public UserResponseModel adduser(@RequestBody User user)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] email= decoder.decode(user.getEmail());
        byte[] password= decoder.decode(user.getPassword());
        String emailString = new String(email);
        String passwordString=new String(password);
        UserResponseModel userResponseModel= new UserResponseModel();
        try {
                Country countryID = countryRepository.findByCountryName(user.getCountry().getCountryName());
                User userDetails=userRepository.findByEmail(user.getEmail());
                if(userDetails==null) {
                    user.setPassword(passwordString);
                    user.setEmail(emailString);
                    user.setCountry(new Country(countryID.getcID()));
                    user.setToken(UUID.randomUUID().toString());
                    userRepository.save(user);
                    userResponseModel = userAndMessage(user, Signup_Success, true);
                }
                else
                {
                    userResponseModel = userAndMessage(user, Email_Exist, false);
                }
        }
        catch (Exception e) {
            userResponseModel = userAndMessage(user,Signup_Fail,false);

        }

        return userResponseModel;

    }

    public UserResponseModel loginUser(@RequestBody User user)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] email= decoder.decode(user.getEmail());
        byte[] password= decoder.decode(user.getPassword());
        String emailString = new String(email);
       String passwordString=new String(password);
        UserResponseModel userResponseModel=new UserResponseModel();
        User userDetail = userRepository.findByEmail(emailString);
        try
        {
            if(userDetail==null)
            {
                userResponseModel = userAndMessage(user,Not_Registered,false);
            }
            else {
                if (userDetail.getPassword().equals(passwordString)) {
                    userResponseModel = userAndMessage(userDetail, Login_Success, true);
                    setToken(userResponseModel.getToken());
                } else {
                    user.setEmail(emailString);
                    userResponseModel = userAndMessage(user, Login_Fail, false);
                }
            }
        }
        catch (Exception e)
        {
            userResponseModel = userAndMessage(user,e.getMessage(),false);
        }
        return userResponseModel;
    }

    public UserResponseModel userAndMessage(User user,String message,boolean success)
    {
        UserResponseModel userResponseModel=new UserResponseModel();
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] email= decoder.decode(user.getEmail());
//        String emailString = new String(email);
        if(success==true)
        {
            userResponseModel.setMessage(message);
            userResponseModel.setEmail(user.getEmail());
            userResponseModel.setToken(user.getToken());
            userResponseModel.setUsername(user.getUserName());
            userResponseModel.setUserId(user.getUserId().toString());
            userResponseModel.setCountryName(Objects.nonNull(user.getCountry())?user.getCountry().getCountryName():null);
            userResponseModel.setIsSuccess(success);
        }
        else {
            userResponseModel.setMessage(message);
            userResponseModel.setEmail(user.getEmail());
            userResponseModel.setIsSuccess(success);
        }
        return  userResponseModel;
    }
}
