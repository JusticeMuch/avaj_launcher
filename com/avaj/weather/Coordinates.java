package com.avaj.weather;

public class Coordinates {

    private int latitude;
    private int longitude;
    private int height;

    public Coordinates(int latitude, int longitude, int height){
        height = height > 100 ? 100 : height;
        height = height < 0 ? 0 : height;
        latitude = latitude > 90 ? 90 : latitude;
        latitude = latitude < 0 ? 0 : latitude;
        longitude = longitude > 180 ? 180 : longitude;
        longitude = longitude < 0 ? 0 : longitude;

        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getHeight(){
        return this.height;
    }
}
