package com.avaj.weather;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;

public class WeatherProvider {

    String[] WeatherConditions = {"SUN", "RAIN", "SNOW", "FOG"};
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private  WeatherProvider(){}

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int res = coordinates.getHeight() + (coordinates.getLongitude() + coordinates.getLatitude())/2;
        return WeatherConditions[res%4];
    }
}
