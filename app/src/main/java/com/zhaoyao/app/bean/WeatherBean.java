package com.zhaoyao.app.bean;

public class WeatherBean {
    private String weather;
    private int wea_img;

    public WeatherBean(String weather, int wea_img) {
        this.weather = weather;
        this.wea_img = wea_img;
    }

    public String getWeather() {
        return weather;
    }

    public int getWea_img() {
        return wea_img;
    }
}
