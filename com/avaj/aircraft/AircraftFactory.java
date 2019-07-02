package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;

public class AircraftFactory {

    Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(latitude, longitude, height);

        if (type.toLowerCase().equals("baloon"))
            return new Baloon(name, coordinates);
        else if (type.toLowerCase().equals("helicopter"))
            return new Helicopter(name, coordinates);
        else if (type.toLowerCase().equals("jetplane"))
            return new JetPlane(name, coordinates);
        else
            return null;
    }
}
