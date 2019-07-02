package com.avaj.aircraft;

import com.avaj.*;
import com.avaj.aircraft.*;
import com.avaj.weather.*;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
