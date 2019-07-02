package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;
import com.avaj.Weather.*;

public class Helicopter extends Aircraft implements Flyable{
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private WeatherTower weatherTower;

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "Let's just stay still to absorb the sun.");
            put("RAIN", "Its fine, water and oil go nicely together");
            put("FOG", "Whats not seeing?, its not like we need it");
            put("SNOW", "Snow yes, that white stuff that keeps us from getting high");
        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() ,
                    coordinates.getHeight() + 2);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                    coordinates.getHeight());
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() ,
                    coordinates.getHeight() );
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() ,
                    coordinates.getHeight() - 12);

        Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): " + messages.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
