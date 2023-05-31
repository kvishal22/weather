package com.kanna.weathercheck.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kanna.weathercheck.entity.WeatherData;
import com.kanna.weathercheck.entity.WeatherDes;

@Component
public class WeatherService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.apiKey}")
    private  String apiKey;


    public WeatherData getWeatherData(String city) {
        String url ="https://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=" + apiKey +
            "&units=metric";
            System.out.println("Calling URL: " + url);
            Map<String, String>  urlvariables= new HashMap<>();
            urlvariables.put("city", city);
            urlvariables.put("apiKey", apiKey);
            WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
            System.out.println("Response body: " + restTemplate.getForObject(url, String.class));
            return weatherData;
        }
    
    public WeatherDes getWeatherData2(String city) {
         String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";
            String url = API_URL.replace("{city}", city).replace("{apiKey}", apiKey);
            System.out.println("Calling URL: " + url);
            String responseJson = restTemplate.getForObject(url, String.class);
            System.out.println(responseJson);
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseJson);

                JsonNode mainNode = jsonNode.get("main");
                double feelsLike = mainNode.get("feels_like").asDouble();
                JsonNode windNode = jsonNode.get("wind");
                double speed = windNode.get("speed").asDouble();

                WeatherDes weatherdata = new WeatherDes();
                weatherdata.setFeelsLike(feelsLike);
                weatherdata.setSpeed(speed);

                return weatherdata;
            } catch (Exception e) {
                e.printStackTrace();
                return null; 
            }
        }

    
}
