package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;
import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable{

    JetPlane(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    private WeatherTower weatherTower;

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "Let's go out have a fly out.");
            put("RAIN", "What is a little water between turbines");
            put("FOG", "The radar isnt working, so what if I can't see");
            put("SNOW", "Snow yes , the white death approaches");
        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                    coordinates.getHeight());
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 1,
                    coordinates.getHeight());
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() ,
                    coordinates.getHeight() - 7);

        Simulator.writer.println("Jetplane#" + this.name + "(" + this.id + "): " + messages.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            Simulator.writer.println("Jetplane#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
