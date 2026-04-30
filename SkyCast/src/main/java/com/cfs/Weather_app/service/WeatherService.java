package com.cfs.Weather_app.service;

import com.cfs.Weather_app.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.url}")
    private String apifUrl;

    private RestTemplate template=new RestTemplate();

    public String test(){
        return "good";
    }

    public WeatherResponse getData(String city){
        String url=apiUrl + "?key=" + apiKey + "&q=" + city;

        Root response= template.getForObject(url, Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();

        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
        weatherResponse.setCondition(response.getCurrent().getCondition().getText());
        weatherResponse.setTemperature(response.getCurrent().temp_c);

        return weatherResponse;
    }

    public WeatherForecast getForecast(String city, int days){

        WeatherForecast weatherForecast =new WeatherForecast();
        WeatherResponse weatherResponse=getData(city);
        WeatherForecast response=new WeatherForecast();
        response.setWeatherResponse(weatherResponse);

        List<DayTemp> dayList=new ArrayList<>();
        String url=apifUrl + "?key=" + apiKey + "&q=" + city + "&days=" +days;
        Root apiResponse= template.getForObject(url, Root.class);
        Forecast forecast=apiResponse.getForecast();
        ArrayList<Forecastday> forecastday = forecast.getForecastday();
        System.out.println("Forecast days from API: " + forecastday.size());
        for (Forecastday day: forecastday){
            DayTemp d=new DayTemp();
            d.setDate(day.getDate());
            d.setMinTemp(day.getDay().mintemp_c);
            d.setAvrTemp(day.getDay().avgtemp_c);
            d.setMaxTemp(day.getDay().maxtemp_c);
            dayList.add(d);
        }

        response.setDayTemp(dayList);
        return response;

    }
}






