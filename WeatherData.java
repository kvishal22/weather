package com.kanna.weathercheck.entity;

import java.util.List;

    public class WeatherData {
        
        
        public List<WeatherDes> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherDes> weather) {
            this.weather = weather;
        }

        private List<WeatherDes> weather;
        
    } 