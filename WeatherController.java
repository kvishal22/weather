package com.kanna.weathercheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanna.weathercheck.entity.WeatherData;
import com.kanna.weathercheck.entity.WeatherDes;
import com.kanna.weathercheck.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city){
        WeatherData weatherData= weatherService.getWeatherData(city);
        String weatherDesc = weatherData.getWeather().get(0).getDesc();
        return "the weather in " + city + " is " + weatherDesc;
    }
    @GetMapping("/{city}/feelslike")
        public String  getFeelsLikeTemperature(@PathVariable String city) {
            WeatherDes weatherDes = weatherService.getWeatherData2(city);
            return city + " feels like  " + weatherDes.getFeelsLike() ;
        }
        @GetMapping("/{city}/speed")
    public String getSpeed(@PathVariable String city){
        WeatherDes weatherDes = weatherService.getWeatherData2(city);
            return city + " speed is " + weatherDes.getSpeed();
}
    @GetMapping("/temp/{city}")
    public String getTemp(@PathVariable String city){
        WeatherData weatherData= weatherService.getWeatherData(city);
        float weatherTemp = weatherData.getWeather().get(0).getTemp();
        return city + " temp " + weatherTemp;
    } 
    @GetMapping("/main/{city}")
    public String getMainWeather(@PathVariable String city){
        WeatherData weatherData= weatherService.getWeatherData(city);
        String weatherMain = weatherData.getWeather().get(0).getMain();
        return "the weather in " + city + " is " + weatherMain;
    }
    @GetMapping("/id/{city}")
    public String getId(@PathVariable String city){
        WeatherData weatherData = weatherService.getWeatherData(city);
        int weatherId = weatherData.getWeather().get(0).getId();
        return "the city id is " + weatherId;
    }
    
    
}


