package com.avaj.weather;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;

public class Coordinates {

    private int latitude;
    private int longitude;
    private int height;

    Coordinates(int latitude, int longitude, int height){
        height = height > 100 ? 100 : height;
        height = height < 100 ? 0 : height;
        latitude = latitude > 90 ? 90 : latitude;
        latitude = latitude < 0 ? 0 : latitude;
        longitude = longitude > 180 ? 180 : longitude;
        longitude = longitude < 0 ? 0 : longitude;

        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    int getLatitude(){
        return this.latitude;
    }

    int getLongitude(){
        return this.longitude;
    }

    int getHeight(){
        return this.height;
    }
}
