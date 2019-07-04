package com.avaj;

import com.avaj.Tower;
import com.avaj.weather.*;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionChanged();
    }
}
