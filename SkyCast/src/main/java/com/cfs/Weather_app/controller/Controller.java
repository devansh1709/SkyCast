package com.cfs.Weather_app.controller;

import com.cfs.Weather_app.dto.WeatherForecast;
import com.cfs.Weather_app.dto.WeatherResponse;
import com.cfs.Weather_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class Controller {

    @Autowired
    private WeatherService service;


    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){
        return service.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city){
        return service.getData(city);
    }

    @GetMapping("/forecast")
    public WeatherForecast getForecast(@RequestParam String city, @RequestParam int days){
        return service.getForecast(city, days);
    }

}
