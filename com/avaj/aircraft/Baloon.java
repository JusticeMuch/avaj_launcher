package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable{

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private WeatherTower weatherTower;

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "Let's go out and have a picnic on that floaty uppy thing.");
            put("RAIN", "This little light of mine, hope its gonna shine , in this rain");
            put("FOG", "I never needed to see anyway, but I hate the color grey");
            put("SNOW", "Snow yes its coming , as death comes to us all ");
        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 4);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 5);
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 3);
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 15);

        Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): " + messages.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
