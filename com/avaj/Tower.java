package com.avaj;

import java.util.ArrayList;
import java.util.List;
import com.avaj.aircraft.*;

public class Tower {

    private  List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        if (observers.contains(flyable)){   
            return;
        }
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionChanged()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
}
