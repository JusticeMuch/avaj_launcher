package com.avaj.aircraft;

import com.avaj.Tower;
import com.avaj.WeatherTower;
import com.avaj.aircraft.*;
import com.avaj.weather.*;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
