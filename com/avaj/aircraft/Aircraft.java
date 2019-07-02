package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft;
import com.avaj.weather.*;

public class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 0;

    long nextId(){
       return (this.idCounter++);
    }

    Aircraft(String name, Coordinates coordinates){
        idCounter++;
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
}
