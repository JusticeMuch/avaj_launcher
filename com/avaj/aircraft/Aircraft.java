package com.avaj.aircraft;

import com.avaj.Tower;
import com.avaj.WeatherTower;
import com.avaj.aircraft.*;
import com.avaj.weather.*;
import java.io.*;

public class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 0;

    long nextId(){
       return (idCounter++);
    }

    Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
}
