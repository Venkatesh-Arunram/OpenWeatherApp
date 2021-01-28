package com.ns.WeatherAppication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        System.out.println(request.getRequestURL());

        if(request.getMethod().equals("OPTIONS"))
        {
            response.setStatus(200);
            return true;
        }
    if(userService.getToken().equals(request.getHeader("token"))){
        System.out.println("Aaaaa");
    }
    else
    {
        return false;
    }
        return true;
    }
}
