package com.kanna.weathercheck.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDes {

    @JsonProperty("description")
    private String desc;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("main")
    private String main;

    @JsonProperty("temp")
    private float temp;

    @JsonProperty("id")
    private int id;

    @JsonProperty("speed")
    private double speed;


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "WeatherDes [desc=" + desc + ", feelsLike=" + feelsLike + ", main=" + main + ", temp=" + temp + "]";
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
    public double getFeelsLike() {
        return feelsLike;
    }
    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
